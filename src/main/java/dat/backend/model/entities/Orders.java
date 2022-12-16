package dat.backend.model.entities;

import java.sql.Timestamp;

public class Orders {

    int user_id;
    int width;
    int length;
    int total_price;
    private Timestamp created;
    private int order_id;

    public Orders(int user_id, int width, int length, int total_price, Timestamp created) {
        this.user_id = user_id;
        this.width = width;
        this.length = length;
        this.total_price = total_price;
        this.created = created;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    @Override
    public String toString() {
        return "Orders " + "user_id = " + user_id + ", width = " + width +
                ", length = " + length + ", total_price = " + total_price + ", created = " + created;
    }
}
