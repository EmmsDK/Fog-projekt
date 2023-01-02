package dat.backend.control.Orders;

import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Orders.OrdersFacade;
import dat.backend.model.persistence.User.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrdersServlet", value = "/ordersservlet")
public class OrdersServlet extends HttpServlet {
    ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        List<Orders> usersOrders = OrdersFacade.getOrderByUserId(UserFacade.getUserIdbyUsername(username,connectionPool),connectionPool);

        session.setAttribute("usersOrders",usersOrders);

        request.getRequestDispatcher("myOrders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
