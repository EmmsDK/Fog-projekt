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

    public static void createOrderlinesByOrderId(List<BuildingMaterial> buildingMaterialList, int order_id, ConnectionPool connectionPool) throws DatabaseException {
        String sql = "insert into orderline (order_id, material_id, quantity, description) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                for (BuildingMaterial buildingMaterial : buildingMaterialList) {
                    ps.setInt(1, order_id);
                    ps.setInt(2, buildingMaterial.getMaterial_id());
                    ps.setInt(3, buildingMaterial.getQuantity());
                    ps.setString(4, buildingMaterial.getDescription());
                    ps.executeUpdate();
                }
            } catch (SQLException e) {
                throw new DatabaseException(e, "Something went wrong, abandon ship");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
