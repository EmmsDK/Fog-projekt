package dat.backend.control;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Admin", value = "/admin")
public class Admin extends HttpServlet {

    private static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<User> userList = UserFacade.getUsers(connectionPool);
        session.setAttribute("userList", userList);

        List<BuildingMaterial> materialList = BuildingMaterialFacade.getDynamicMaterials(connectionPool);
        session.setAttribute("materialList", materialList);


        List<Orders> ordersList = (List<Orders>) OrdersFacade.getOrders(connectionPool);

        System.out.println(ordersList);

        session.setAttribute("ordersList", ordersList);

        request.getRequestDispatcher("/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}