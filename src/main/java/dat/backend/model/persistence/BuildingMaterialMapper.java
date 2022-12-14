package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static dat.backend.model.persistence.UserMapper.connectionPool;

public class BuildingMaterialMapper {
    public static List<BuildingMaterial> getStaticMaterials(ConnectionPool connectionPool) {

        List<BuildingMaterial> staticMaterials = new ArrayList<>();

        String sql = "select * from material where type_id > 2";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int type_id = rs.getInt("typeId");
                    int quantity = 1;
                    int length = rs.getInt("length");
                    int material_id = rs.getInt("material_id");


                    if (type_id == 4) {
                        BuildingMaterial newScrew = new Screw(type, description, length, material_id, quantity, type_id);
                        staticMaterials.add(newScrew);
                    } else {

                        BuildingMaterial newFitting = new Fitting(type, description, length, material_id, quantity, type_id);
                        staticMaterials.add(newFitting);

                    }

                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return staticMaterials;
    }

    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool) {

        List<BuildingMaterial> dynamicMaterials = new ArrayList<>();

        String sql = "select * from material where type_id < 3";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int type_id = rs.getInt("typeId");
                    int quantity = 1;
                    int length = rs.getInt("length");
                    int material_id=rs.getInt("material_id");

                    if (type_id == 1) {
                        BuildingMaterial newWood = new Wood(type,description, length, material_id, quantity, type_id);
                        dynamicMaterials.add(newWood);
                    }else {

                        BuildingMaterial newRoofTile = new RoofTile(type, description, length, material_id, quantity, type_id);
                        dynamicMaterials.add(newRoofTile);

                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dynamicMaterials;
    }

    public static Material createMaterial(String type, String description, int length, int type_id) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Material createMaterial;
        String sql = "insert into material (type, description, length, type_id) values (?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, type);
                ps.setString(2, description);
                ps.setInt(3, length);
                ps.setInt(4, type_id);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    createMaterial = new Material(type, description, length, type_id);
                } else {
                    throw new DatabaseException("The material = " + type + " could not be inserted into the database");
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Could not insert material into database");
        }
        return createMaterial;
    }
}
