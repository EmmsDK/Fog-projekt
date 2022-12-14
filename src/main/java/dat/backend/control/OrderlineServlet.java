package dat.backend.control;

import dat.backend.model.entities.Orderline;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Orderline", value = "/orderline")
public class OrderlineServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Orderline cart = (Orderline) session.getAttribute("cart");

        int material_id = Integer.parseInt(request.getParameter("material_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int totalPrice = 0;

        Orderline orderline = new Orderline(material_id,order_id,quantity,description);
        cart.add(orderline);

        session.setAttribute("cart",cart);
        request.setAttribute("cartsize",cart.getOrderlineSize());
        request.setAttribute("totalprice",totalPrice);

        request.getRequestDispatcher("myOrders.jsp").forward(request,response);
    }
}
