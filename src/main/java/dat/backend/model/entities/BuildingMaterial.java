package dat.backend.model.entities;

public abstract class BuildingMaterial {

    private String type;
    private String description;
    private int typeId;

    public BuildingMaterial(String type, String description, int typeId) {
        this.type = type;
        this.description = description;
        this.typeId = typeId;
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

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
}
