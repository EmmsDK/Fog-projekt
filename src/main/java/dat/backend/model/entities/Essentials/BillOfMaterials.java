package dat.backend.model.entities.Essentials;

import dat.backend.model.entities.BuildingMaterial;

import java.util.List;

public class BillOfMaterials {
    List<BuildingMaterial> materialList;

    public BillOfMaterials(List<BuildingMaterial> materialList) {
        this.materialList = materialList;
    }
}
