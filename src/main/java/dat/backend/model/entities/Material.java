package dat.backend.model.entities;

public class Material {

    int material_id;
    String type;
    String description;
    int length;
    int type_id;
    int price;

    public Material(String type, String description, int length, int type_id, int price) {
        this.type = type;
        this.description = description;
        this.length = length;
        this.type_id = type_id;
    }

    public Material(int material_id, String type, String description, int length, int type_id, int price) {
        this.material_id = material_id;
        this.type = type;
        this.description = description;
        this.length = length;
        this.type_id = type_id;
        this.price = price;
    }

    public int getMaterial_id() {
        return material_id;
    }

    public void setMaterial_id(int material_id) {
        this.material_id = material_id;
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

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }
}
