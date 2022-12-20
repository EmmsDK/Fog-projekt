package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.entities.Essentials.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.User.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrdersMapper {

    public static ConnectionPool connectionPool = new ConnectionPool();

    public static Orders createOrders(User user, Orders orders, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Orders createOrders;
        String sql = "insert into orders (user_id, width, length, total_price) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user.getIduser());
                ps.setInt(2, orders.getWidth());
                ps.setInt(3, orders.getLength());
                ps.setInt(4, orders.getTotal_price());
                ps.setTimestamp(5, orders.getCreated());
                ps.executeUpdate();
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    createOrders = new Orders(user.getIduser(), orders.getWidth(), orders.getLength(), orders.getTotal_price(), orders.getCreated());
                } else {
                    throw new DatabaseException("The order = " + orders + " could not be inserted into the database");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Something went wrong, abandon ship");
        }
        return createOrders;
    }

    public static List<Orders> getOrders(ConnectionPool connectionPool) {

        Logger.getLogger("web").log(Level.INFO, "");
        List<Orders> ordersList = new ArrayList<>();

        String sql = "select * from orders";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    int width = rs.getInt("width");
                    int length = rs.getInt("length");
                    int total_price = rs.getInt("total_price");
                    Timestamp created = rs.getTimestamp("created");
                    int order_id = rs.getInt("order_id");


                    Orders newOrders = new Orders(user_id, width, length, total_price, created, order_id);
                    ordersList.add(newOrders);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ordersList;
    }

    public static boolean removeOrder(int order_id, ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "delete from orders where order_id = ?";
        try (Connection connection = OrdersMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Order med order ID = " + order_id + " kunne ikke fjernes");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (DatabaseException e) {
                e.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public boolean updateOrder(Orders order) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean result = false;
        String sql = "UPDATE orders SET width = ?, length = ?, total_price = ? " +
                "WHERE user_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, order.getWidth());
                ps.setInt(2, order.getLength());
                ps.setInt(3, order.getTotal_price());
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    result = true;
                } else {
                    throw new DatabaseException("Kunne ikke opdatere ordre med order_id = " + order.getOrder_id());
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException("Kunne ikke opdatere ordre med order_id = " + order.getOrder_id());
        }
        return result;
    }
}
