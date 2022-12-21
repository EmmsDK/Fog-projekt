package dat.backend.model.persistence.User;

import dat.backend.model.entities.Essentials.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String role, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(username, password, role, connectionPool);
    }

    public static List<User> getUsers(ConnectionPool connectionPool) {
        return UserMapper.getUsers(connectionPool);
    }


    public static int getUserIdbyUsername(String username, ConnectionPool connectionPool){
        return UserMapper.getUserIdbyUsername(username, connectionPool);
    }
}
