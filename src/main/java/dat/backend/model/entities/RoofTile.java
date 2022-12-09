package dat.backend.model.entities;

public class RoofTile extends BuildingMaterial{
    private int length;

    public RoofTile(String type, String description, int typeId, int length) {
        super(type, description, typeId);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
