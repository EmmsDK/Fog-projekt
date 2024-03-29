package dat.backend.model.entities.Essentials;

import java.util.ArrayList;
import java.util.List;

public class Orderline {

    List<Orderline> orderlineList = new ArrayList<>();

    int material_id;
    int order_id;
    int quantity;
    String description;

    public Orderline(int material_id, int order_id, int quantity, String description) {
        this.material_id = material_id;
        this.order_id = order_id;
        this.quantity = quantity;
        this.description = description;
    }

    public void add(Orderline orderline) {
        orderlineList.add(orderline);
    }

    public int getOrderlineSize(){
        return orderlineList.size();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
