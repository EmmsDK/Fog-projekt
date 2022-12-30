package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.BuildingMaterial;
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

    public static void createOrders(User user, Orders orders, List<BuildingMaterial> buildingMaterialList, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        String sql = "insert into orders (user_id, width, length, total_price) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, user.getUser_id());
                ps.setInt(2, orders.getWidth());
                ps.setInt(3, orders.getLength());
                ps.setInt(4, orders.getTotal_price());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                sql = "insert into orderline (order_id, material_id, quantity, description) values (?,?,?,?)";
                try (PreparedStatement ps2 = connection.prepareStatement(sql)) {
                    for (BuildingMaterial buildingMaterial : buildingMaterialList) {
                        ps2.setInt(1, rs.getInt(1));
                        ps2.setInt(2, buildingMaterial.getMaterial_id());
                        ps2.setInt(3, buildingMaterial.getQuantity());
                        ps2.setString(4, buildingMaterial.getDescription());
                        ps2.executeUpdate();
                    }
                } catch (SQLException e) {
                    throw new DatabaseException(e, "Something went wrong, abandon ship");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Something went wrong, abandon ship");
        }
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

    public static List<Orders> getOrderByUserId(int user_id, ConnectionPool connectionPool) {
        String sql = "select * from orders where user_id = ?";
        List<Orders> myOrders = new ArrayList<>();
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, user_id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_id = rs.getInt("order_id");

                    int width = rs.getInt("width");
                    int length = rs.getInt("length");

                    int total_price = rs.getInt("total_price");
                    Timestamp created = rs.getTimestamp("created");


                    Orders order = new Orders(user_id, width, length, total_price, created, order_id);
                    myOrders.add(order);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myOrders;
    }

}
