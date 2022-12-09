package dat.backend.model.persistence;

import dat.backend.model.entities.BuildingMaterial;

import java.util.List;

public class BuildingMaterialFacade {
    public static List<BuildingMaterial> getStaticMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getStaticMaterials(connectionPool);
    }
    public static List<BuildingMaterial> getDynamicMaterials(ConnectionPool connectionPool){
        return BuildingMaterialMapper.getDynamicMaterials(connectionPool);
    }
}
