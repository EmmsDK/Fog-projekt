package dat.backend.model.persistence;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;

import java.util.List;

public class BuildingMaterialFacade {
    public static List<BuildingMaterial> getStaticMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getStaticMaterials(connectionPool);
    }
    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getDynamicMaterials(connectionPool);
    }
    public static Material createMaterial(String type, String description, int length, int type_id) throws DatabaseException {
        return BuildingMaterialMapper.createMaterial(type, description, length, type_id);
    }

    public static void updateMaterialName(int item_id, String name, ConnectionPool connectionPool) {
        BuildingMaterialMapper.updateMaterialName(item_id, name, connectionPool);

    }
}
