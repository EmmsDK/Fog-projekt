package dat.backend.model.entities;

import dat.backend.model.persistence.BuildingMaterialFacade;
import dat.backend.model.persistence.BuildingMaterialMapper;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {
    ConnectionPool connectionPool = new ConnectionPool();
    List<BuildingMaterial> materialList = new ArrayList<>();

    public BillOfMaterials(List<BuildingMaterial> materialList) {
        this.materialList = materialList;
    }

    public List<BuildingMaterial> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<BuildingMaterial> materialList) {
        this.materialList = materialList;
    }

    public void loadStaticMats() {
        setMaterialList(BuildingMaterialMapper.getStaticMaterials(connectionPool));
    }
}
