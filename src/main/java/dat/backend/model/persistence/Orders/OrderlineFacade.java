package dat.backend.model.persistence.Orders;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Essentials.Orderline;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;

import java.util.List;

public class OrderlineFacade {
    public static void createOrderlinesByOrderId(List<BuildingMaterial> BoM, ConnectionPool connectionPool) throws DatabaseException {
        OrderlineMapper.createOrderlinesByOrderId(BoM,connectionPool);
    }
}
