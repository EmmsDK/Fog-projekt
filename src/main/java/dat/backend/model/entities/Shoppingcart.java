package dat.backend.model.entities;

import java.security.Timestamp;

public class Shoppingcart {
    Carport carport;


    public Shoppingcart(Carport carport) {
        this.carport = carport;

    }

    public Carport getCarport() {
        return carport;
    }

    public void setCarport(Carport carport) {
        this.carport = carport;
    }

}
