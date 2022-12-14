package dat.backend.model.entities;

public abstract class BuildingMaterial {

    private String type;
    private String description;

    int length;
    int material_id;

    private int quantity;

    int type_id;

    public BuildingMaterial(String type, String description, int length, int material_id, int quantity, int type_id) {
        this.type = type;
        this.description = description;
        this.length = length;
        this.material_id = material_id;
        this.quantity = quantity;
        this.type_id = type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}


