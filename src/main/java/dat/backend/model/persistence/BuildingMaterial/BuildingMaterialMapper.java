package dat.backend.model.persistence.BuildingMaterial;

import dat.backend.model.entities.*;
import dat.backend.model.entities.Materials.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.User.UserMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                    int type_id = rs.getInt("type_id");
                    int quantity = 1;
                    int length = rs.getInt("length");
                    int material_id = rs.getInt("material_id");
                    int price = rs.getInt("price");


                    if (type_id == 4) {
                        BuildingMaterial newScrew = new Screw(type, description, length, material_id, quantity, type_id, price);
                        staticMaterials.add(newScrew);
                    } else {

                        BuildingMaterial newFitting = new Fitting(type, description, length, material_id, quantity, type_id, price);
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
                    int type_id = rs.getInt("type_id");
                    int quantity = 1;
                    int length = rs.getInt("length");
                    int material_id = rs.getInt("material_id");
                    int price = rs.getInt("price");


                    if (type_id == 1) {
                        BuildingMaterial newWood = new Wood(type, description, length, material_id, quantity, type_id, price);
                        dynamicMaterials.add(newWood);
                    } else {

                        BuildingMaterial newRoofTile = new RoofTile(type, description, length, material_id, quantity, type_id, price);
                        dynamicMaterials.add(newRoofTile);
                    }
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("help");
        return dynamicMaterials;
    }

    public static Material createMaterial(String type, String description, int length, int type_id, int price, ConnectionPool connectionPool) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        Material createMaterial;
        String sql = "insert into material (type, description, length, type_id, price) values (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, type);
                ps.setString(2, description);
                ps.setInt(3, length);
                ps.setInt(4, type_id);
                ps.setInt(5, price);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    createMaterial = new Material(type, description, length, type_id, price);
                } else {
                    throw new DatabaseException("The material = " + type + " could not be inserted into the database");
                }
            }
        } catch (SQLException | DatabaseException ex) {
            throw new DatabaseException(ex, "Could not insert material into database");
        }
        return createMaterial;
    }

    public static void updateMaterial(int material_id, String type, String description, int length, int price, ConnectionPool connectionPool) {
        String sql = "UPDATE material SET type = ?, description = ?, length = ?, price = ? WHERE material_id = "+material_id+"";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, type);
                ps.setString(2, description);
                ps.setInt(3, length);
                ps.setInt(4, price);
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
                    int price = rs.getInt("price");

                    Material newMaterial = new Material(id, type, description, length, type_id, price);
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

    public static List<BuildingMaterial> getAllMaterials(ConnectionPool connectionPool) {

        List<BuildingMaterial> allMaterials = new ArrayList<>();

        String sql = "select * from material";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int type_id = rs.getInt("type_id");
                    int quantity = 1;
                    int length = rs.getInt("length");
                    int material_id = rs.getInt("material_id");
                    int price = rs.getInt("price");


                    switch (type_id) {
                        case 4:
                            BuildingMaterial newScrew = new Screw(type, description, length, material_id, quantity, type_id, price);
                            allMaterials.add(newScrew);
                            break;
                        case 3:
                            BuildingMaterial newFitting = new Fitting(type, description, length, material_id, quantity, type_id, price);
                            allMaterials.add(newFitting);
                            break;
                        case 2:
                            BuildingMaterial newRoofTile = new RoofTile(type, description, length, material_id, quantity, type_id, price);
                            allMaterials.add(newRoofTile);
                            break;
                        case 1:
                            BuildingMaterial newWood = new Wood(type, description, length, material_id, quantity, type_id, price);
                            allMaterials.add(newWood);
                            break;
                    }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    } catch(
    SQLException throwables)

    {
        throwables.printStackTrace();
    }

        return allMaterials;
}
}

