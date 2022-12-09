package dat.backend.model.persistence;

import dat.backend.model.entities.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BuildingMaterialMapper {
    public static List<BuildingMaterial> getStaticMaterials(ConnectionPool connectionPool) {


        List<BuildingMaterial> staticMaterials = new ArrayList<>();

        String sql = "select * from beslag";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");


                    BuildingMaterial newFitting = new Fitting(type,description,typeId);
                    staticMaterials.add(newFitting);
                }
            }

            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql = "select * from skruer";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");


                    BuildingMaterial newScrew = new Screw(type,description,typeId);
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
        }

        return staticMaterials;
    }

    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool) {


        List<BuildingMaterial> dynamicMaterials = new ArrayList<>();

        String sql = "select * from tree";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int length=rs.getInt("length");


                    BuildingMaterial newWood = new Wood(type,description,typeId,length);
                    dynamicMaterials.add(newWood);
                }
            }

            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql = "select * from tagplader";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int length=rs.getInt("length");


                    BuildingMaterial newRoofTile = new RoofTile(type,description,typeId,length);
                    dynamicMaterials.add(newRoofTile);
                }
            }
            try (PreparedStatement ps = connection.prepareStatement(sql)) {


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return dynamicMaterials;
    }
}
