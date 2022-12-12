package dat.backend.model.persistence;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

public class OrdersFacade {

    public static Orders createOrders(User user, Orders orders, ConnectionPool connectionPool) throws DatabaseException {
        return OrdersMapper.createOrders(user,orders,connectionPool);
    }

    public static Object getOrders(ConnectionPool connectionPool) {
        return OrdersMapper.getOrders(connectionPool);
    }
}
