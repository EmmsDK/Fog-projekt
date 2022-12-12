package dat.backend.model.entities;

import dat.backend.model.persistence.BuildingMaterialFacade;
import dat.backend.model.persistence.BuildingMaterialMapper;
import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {
    ConnectionPool connectionPool = new ConnectionPool();
    List<BuildingMaterial> materialList = new ArrayList<>();

    List<Integer> quantity = new ArrayList<>();
    //


    public BillOfMaterials(List<BuildingMaterial> materialList, List<Integer> quantity) {
        this.materialList = materialList;
        this.quantity = quantity;
    }

    public List<BuildingMaterial> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<BuildingMaterial> materialList) {
        this.materialList = materialList;
    }

    public List<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(List<Integer> quantity) {
        this.quantity = quantity;
    }

    public void loadStaticMats(){
        int i=1;
        setMaterialList(BuildingMaterialMapper.getStaticMaterials(connectionPool));
        for (BuildingMaterial material:materialList) {
            if (i == 3) {
                i=1;
            }
                this.quantity.add(i);
            i++;
            }
    }

    public void loadDynamicMats(List<BuildingMaterial> dynamicList){
        for(BuildingMaterial material:dynamicList){
            this.materialList.add(material);
        }
    }
}
