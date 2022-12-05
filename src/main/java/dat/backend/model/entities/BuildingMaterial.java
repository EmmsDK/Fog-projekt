package dat.backend.model.entities;

public abstract class BuildingMaterial {
    private int price;
    private int width;
    private int length;
    private String name;
    private String unit;
    
    public BuildingMaterial(int price, int width, int length, String name, String unit) {
        this.price = price;
        this.width = width;
        this.length = length;
        this.name = name;
        this.unit=unit;
    }
}
