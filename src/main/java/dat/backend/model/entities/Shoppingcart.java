package dat.backend.model.entities;

import java.security.Timestamp;

public class Shoppingcart {
    Carport carport;
    int idshoppingcart;

    public Shoppingcart(Carport carport) {
        this.carport = carport;

    }

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

    public int getIdshoppingcart() {
        return idshoppingcart;
    }

    public void setIdshoppingcart(int idshoppingcart) {
        this.idshoppingcart = idshoppingcart;
    }
}
