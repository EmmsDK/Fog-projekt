package dat.backend.control;

import dat.backend.model.entities.User;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.OrdersFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        List<Orders> list = (List<Orders>) OrdersFacade.getOrders(connectionPool);

        session.setAttribute("list", list);
        request.getRequestDispatcher("admin.jsp").forward(request, response);


    }
}
