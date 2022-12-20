package dat.backend.control.Material;

import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Orders.OrdersFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RemoveOrder", value = "/removeorder")
public class RemoveOrder extends HttpServlet {

    private static final ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int order_id = Integer.parseInt(request.getParameter("order_id"));

        OrdersFacade.removeOrder(order_id,connectionPool);
        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
        ordersList.removeIf(orders -> orders.getOrder_id()==order_id);

        session.setAttribute("ordersList",ordersList);
        request.getRequestDispatcher("/portfolio.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
