package dat.backend.model.persistence;

import dat.backend.model.entities.Orderline;
import dat.backend.model.entities.Shoppingcart;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.backend.model.persistence.UserMapper.connectionPool;

public class OrdersMapper {
    static Orderline createOrders(User user, Orderline cart) throws DatabaseException {
        String sql = "insert into shoppingcart (user_id, idorderline, shoppingcarttotalprice,) values (?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, user.getIduser());

                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                rs.next();
                cart.setOrderline_id(rs.getInt(1));

                int rowsAffected = ps.executeUpdate();

            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return cart;
    }
}