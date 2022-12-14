package dat.backend.model.entities;

public class Screw extends BuildingMaterial{

    public Screw(String type, String description, int length, int material_id, int quantity, int type_id, int price) {
        super(type, description, length, material_id, quantity, type_id, price);
    }
}
