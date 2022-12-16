package dat.backend.control;

import dat.backend.model.entities.Orders;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrdersFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "RemoveOrder", value = "/removeorder")
public class RemoveOrder extends HttpServlet {

    private static final ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int user_id = Integer.parseInt(request.getParameter("user_id"));

        boolean removeOrders = OrdersFacade.removeOrder(user_id, connectionPool);

        session.setAttribute("removeOrders", removeOrders);

        request.getRequestDispatcher("/portfolio.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
