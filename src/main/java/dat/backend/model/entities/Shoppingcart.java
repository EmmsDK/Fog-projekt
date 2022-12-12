package dat.backend.model.entities;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

}
