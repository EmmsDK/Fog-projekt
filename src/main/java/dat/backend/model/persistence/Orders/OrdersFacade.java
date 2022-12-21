package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.entities.Essentials.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class OrdersFacade {

    public static Orders createOrders(User user, Orders orders, ConnectionPool connectionPool) throws DatabaseException {
        return OrdersMapper.createOrders(user,orders,connectionPool);
    }

    public static Object getOrders(ConnectionPool connectionPool) {
        return OrdersMapper.getOrders(connectionPool);
    }
    public static boolean removeOrder(int order_id, ConnectionPool connectionPool) {
        return OrdersMapper.removeOrder(order_id, connectionPool);
    }
    public static List<Orders> getOrderByUserId(int user_id, ConnectionPool connectionPool) {
        return OrdersMapper.getOrderByUserId(user_id, connectionPool);
    }
}
