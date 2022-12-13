package dat.backend.model.entities;

public class Material {

    String type;
    String description;
    int length;
    int type_id;

    public Material(String type, String description, int length, int type_id) {
        this.type = type;
        this.description = description;
        this.length = length;
        this.type_id = type_id;
    }
}
