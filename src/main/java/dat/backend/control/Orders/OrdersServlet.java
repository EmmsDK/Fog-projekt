package dat.backend.control.Orders;

import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Orders.OrdersFacade;
import dat.backend.model.persistence.User.UserFacade;
import dat.backend.model.persistence.User.UserMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
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
        /*Orders list = (Orders) session.getAttribute("list");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int total_price = Integer.parseInt(request.getParameter("total_price"));
        Timestamp created = Timestamp.valueOf(request.getParameter("created"));

        Orders orders = new Orders(user_id,width,length,total_price,created);
        list.add(orders);

        session.setAttribute("list",list);*/

        request.getRequestDispatcher("myOrders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       /* response.setContentType("text/html");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");

        List<Orders> usersOrders = OrdersFacade.getOrderByUserId(UserFacade.getUserIdbyUsername(username,connectionPool),connectionPool);

        session.setAttribute("usersOrders",usersOrders);
        /*Orders list = (Orders) session.getAttribute("list");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int total_price = Integer.parseInt(request.getParameter("total_price"));
        Timestamp created = Timestamp.valueOf(request.getParameter("created"));

        Orders orders = new Orders(user_id,width,length,total_price,created);
        list.add(orders);

        session.setAttribute("list",list);

        //request.getRequestDispatcher("myOrders.jsp").forward(request, response);
*/

    }
}
