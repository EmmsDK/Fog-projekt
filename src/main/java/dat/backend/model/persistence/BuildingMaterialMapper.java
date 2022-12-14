package dat.backend.model.persistence;

import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;

import java.sql.*;
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
                    int typeId = rs.getInt("type_id");
                    int quantity = 3;

                    if (typeId == 4) {
                        BuildingMaterial newScrew = new Screw(type, description, typeId, quantity);
                        staticMaterials.add(newScrew);
                    }

                    BuildingMaterial newFitting = new Fitting(type, description, typeId, quantity);
                    staticMaterials.add(newFitting);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
       /* sql = "select * from skruer";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int quantity = rs.getInt("quantity");


                    BuildingMaterial newScrew = new Screw(type,description,typeId,quantity);
                    staticMaterials.add(newScrew);
                }
            }
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/

        return staticMaterials;
    }

    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool) {

        List<BuildingMaterial> dynamicMaterials = new ArrayList<>();
        String sql = "select * from material where type_id > 3";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int quantity = rs.getInt("quantity");
                    int length = rs.getInt("length");

                    BuildingMaterial newWood = new Wood(type, description, typeId, quantity, length);
                    dynamicMaterials.add(newWood);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
        sql = "select * from rooftiles";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int quantity = rs.getInt("quantity");
                    int length = rs.getInt("length");

                    BuildingMaterial newRoofTile = new RoofTile(type, description, typeId, quantity, length);
                    dynamicMaterials.add(newRoofTile);
                }
            }
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */

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

    public static void updateMaterial(int material_id, String type, String description, int length, int type_id, ConnectionPool connectionPool) {
        String sql = "UPDATE material SET type = ? SET description = ? SET length = ? SET type_id = ? WHERE material_id = ?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, material_id);
                ps.setString(2, type);
                ps.setString(3, description);
                ps.setInt(4, length);
                ps.setInt(5, type_id);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Material getMaterialById(int material_id, ConnectionPool connectionPool) {
        String sql = "select * from material where item_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, material_id);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    int id = rs.getInt("material_id");
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int length = rs.getInt("length");
                    int type_id = rs.getInt("type_id");

                    Material newMaterial = new Material(id, type, description, length, type_id);
                    return newMaterial;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

