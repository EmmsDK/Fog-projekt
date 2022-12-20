package dat.backend.model.entities;

import dat.backend.model.persistence.ConnectionPool;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {
    ConnectionPool connectionPool = new ConnectionPool();
    List<BuildingMaterial> materialList = new ArrayList<>();

    public BillOfMaterials(ConnectionPool connectionPool, List<BuildingMaterial> materialList) {
        this.materialList = materialList;
    }
}
