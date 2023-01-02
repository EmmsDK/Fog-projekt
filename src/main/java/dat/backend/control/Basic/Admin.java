package dat.backend.control.Basic;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.entities.Essentials.User;
import dat.backend.model.persistence.*;
import dat.backend.model.persistence.BuildingMaterial.BuildingMaterialFacade;
import dat.backend.model.persistence.Orders.OrdersFacade;
import dat.backend.model.persistence.User.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {

    private static final ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<User> userList = UserFacade.getUsers();
        session.setAttribute("userList", userList);

        List<BuildingMaterial> materialList = BuildingMaterialFacade.getAllMaterials();
        session.setAttribute("materialList", materialList);


        List<Orders> ordersList = (List<Orders>) OrdersFacade.getOrders();

        System.out.println(ordersList);

        session.setAttribute("ordersList", ordersList);

        request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}