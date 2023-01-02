package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.entities.Essentials.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class OrdersFacade {

    public static void createOrders(User user, Orders orders, List<BuildingMaterial> buildingMaterialList, ConnectionPool connectionPool) throws DatabaseException {
        OrdersMapper.createOrders(user,orders, buildingMaterialList, connectionPool);
    }

    public static Object getOrders() {
        return OrdersMapper.getOrders();
    }
    public static void removeOrder(int order_id) {
        OrdersMapper.removeOrder(order_id);
    }
    public static List<Orders> getOrderByUserId(int user_id, ConnectionPool connectionPool) {
        return OrdersMapper.getOrderByUserId(user_id, connectionPool);
    }
}
