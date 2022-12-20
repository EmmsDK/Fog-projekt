package dat.backend.model.persistence.BuildingMaterial;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Materials.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class BuildingMaterialFacade {
    public static List<BuildingMaterial> getStaticMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getStaticMaterials(connectionPool);
    }
    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getDynamicMaterials(connectionPool);
    }
    public static List<BuildingMaterial> getAllMaterials(ConnectionPool connectionPool) {
        return BuildingMaterialMapper.getAllMaterials(connectionPool);
    }
    public static Material createMaterial(String type, String description, int length, int type_id, int price, ConnectionPool connectionPool) throws DatabaseException {
        return BuildingMaterialMapper.createMaterial(type, description, length, type_id, price, connectionPool);
    }

    public static void updateMaterial(int material_id, String type, String description, int length, int price, ConnectionPool connectionPool) {
        BuildingMaterialMapper.updateMaterial(material_id, type, description, length, price, connectionPool);
    }

    public static Material getMaterialById(int material_id, ConnectionPool connectionPool){
        return BuildingMaterialMapper.getMaterialById(material_id,connectionPool);
    }
}