package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

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
                ps.executeUpdate();
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    createOrders = new Orders(user.getIduser(),orders.getWidth(),orders.getLength(),orders.getTotal_price());
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

                    Orders newOrders = new Orders(user_id,width,length,total_price);
                    ordersList.add(newOrders);
                }
            }catch (SQLException throwables){
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ordersList;
    }
}