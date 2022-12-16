package dat.backend.control;

import dat.backend.model.entities.Orders;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrdersFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersServlet", value = "/orders")
public class OrdersServlet extends HttpServlet {

    private static final ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<Orders> ordersList = (List<Orders>) OrdersFacade.getOrders(connectionPool);

        System.out.println(ordersList);

        session.setAttribute("ordersList", ordersList);
        request.getRequestDispatcher("admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
