package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class UserMapper {

    public static ConnectionPool connectionPool = new ConnectionPool();

    static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User user = null;

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    user = new User(username, password);
                } else {
                    throw new DatabaseException("Wrong username or password");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Error logging in. Something went wrong with the database");
        }
        return user;
    }

    static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        User createUser;
        String sql = "insert into User (username, password, role) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, "User");
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    createUser = new User(username, password);
                } else {
                    throw new DatabaseException("The user with username = " + username + " could not be inserted into the database");
                }
            }
        }
        catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert username into database");
        }
        return createUser;
    }

    public static List<User> getUsers(ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        List<User> userList = new ArrayList<>();

        String sql = "select * from user";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int userid=rs.getInt("iduser");
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String role = rs.getString("role");

                    User newUser = new User(userid, username, password, role);
                    userList.add(newUser);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
