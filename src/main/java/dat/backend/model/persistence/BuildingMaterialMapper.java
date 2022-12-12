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

        String sql = "select * from material where type_id > 2";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("type_id");
                    int quantity = 3;

                    if(typeId==4){
                        BuildingMaterial newScrew = new Screw(type,description,typeId,quantity);
                        staticMaterials.add(newScrew);
                    }


                    BuildingMaterial newFitting = new Fitting(type,description,typeId,quantity);
                    staticMaterials.add(newFitting);
                }
            }

            catch (SQLException throwables) {
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
                    int length=rs.getInt("length");


                    BuildingMaterial newWood = new Wood(type,description,typeId,quantity,length);
                    dynamicMaterials.add(newWood);
                }
            }

            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        sql = "select * from rooftiles";

        try (Connection connection = UserMapper.connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String type = rs.getString("type");
                    String description = rs.getString("description");
                    int typeId = rs.getInt("typeId");
                    int quantity = rs.getInt("quantity");
                    int length=rs.getInt("length");


                    BuildingMaterial newRoofTile = new RoofTile(type,description,typeId,quantity,length);
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
