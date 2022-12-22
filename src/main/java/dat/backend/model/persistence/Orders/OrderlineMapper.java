package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderlineMapper {
    public static ConnectionPool connectionPool = new ConnectionPool();

    public static void createOrderlinesByOrderId(List<BuildingMaterial> BoM, ConnectionPool connectionPool) throws DatabaseException {
        int order_id = OrdersMapper.getOrders(connectionPool).get(OrdersMapper.getOrders(connectionPool).size() - 1).getOrder_id();
        String sql = "insert into orderline (material_id, order_id, quantity, description) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                for (BuildingMaterial buildingMaterial : BoM) {
                    ps.setInt(1, buildingMaterial.getMaterial_id());
                    ps.setInt(2, order_id);
                    ps.setInt(3, buildingMaterial.getQuantity());
                    ps.setString(4, buildingMaterial.getDescription());
                    ps.executeUpdate();
                    int rowsAffected = ps.executeUpdate();

                    throw new DatabaseException("The orderlines could not be inserted into the database");
                }
            }
        } catch (SQLException e) {
            throw new DatabaseException(e, "Something went wrong, abandon ship");
        }
    }
}
