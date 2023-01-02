package dat.backend.model.persistence.BuildingMaterial;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Materials.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class BuildingMaterialFacade {
    public static List<BuildingMaterial> getStaticMaterials(){
        return BuildingMaterialMapper.getStaticMaterials();
    }
    public static List<BuildingMaterial> getDynamicMaterials(){
        return BuildingMaterialMapper.getDynamicMaterials();
    }
    public static List<BuildingMaterial> getAllMaterials() {
        return BuildingMaterialMapper.getAllMaterials();
    }
    public static Material createMaterial(String type, String description, int length, int type_id, int price, ConnectionPool connectionPool) throws DatabaseException {
        return BuildingMaterialMapper.createMaterial(type, description, length, type_id, price, connectionPool);
    }

    public static void updateMaterial(int material_id, String type, String description, int length, int price, ConnectionPool connectionPool) {
        BuildingMaterialMapper.updateMaterial(material_id, type, description, length, price, connectionPool);
    }

}
