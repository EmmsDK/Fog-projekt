package dat.backend.model.entities.Materials;

import dat.backend.model.entities.BuildingMaterial;

public class Fitting extends BuildingMaterial {
    public Fitting(String type, String description, int length, int material_id, int quantity, int type_id, int price) {
        super(type, description, length, material_id, quantity, type_id, price);
    }
}

