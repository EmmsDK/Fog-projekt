package dat.backend.model.entities;

public class Wood extends BuildingMaterial {
    private int length;

    public Wood(String type, String description, int type_id, int length) {
        super(type, description, type_id, length);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
