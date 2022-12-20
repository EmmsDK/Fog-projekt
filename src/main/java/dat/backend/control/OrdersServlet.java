package dat.backend.control;

import dat.backend.model.entities.Orders;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "OrdersServlet", value = "/ordersservlet")
public class OrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        Orders list = (Orders) session.getAttribute("list");

        int user_id = Integer.parseInt(request.getParameter("user_id"));
        int width = Integer.parseInt(request.getParameter("width"));
        int length = Integer.parseInt(request.getParameter("length"));
        int total_price = Integer.parseInt(request.getParameter("total_price"));
        Timestamp created = Timestamp.valueOf(request.getParameter("created"));

        Orders orders = new Orders(user_id,width,length,total_price,created);
        list.add(orders);

        session.setAttribute("list",list);

        request.getRequestDispatcher("myOrders.jsp").forward(request, response);
    }
}
