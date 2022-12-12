package dat.backend.model.entities;

public class Orders {

    int user_id;
    int width;
    int length;
    int total_price;

    public Orders(int user_id, int width, int length, int total_price) {
        this.user_id = user_id;
        this.width = width;
        this.length = length;
        this.total_price = total_price;
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
}
