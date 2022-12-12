package dat.backend.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Orderline", value = "/Orderline")
public class Orderline extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        dat.backend.model.entities.Orderline cart = (dat.backend.model.entities.Orderline) session.getAttribute("cart");

        int material_id = Integer.parseInt(request.getParameter("material_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String description = request.getParameter("description");
        int totalPrice = 0;

        dat.backend.model.entities.Orderline orderline = new dat.backend.model.entities.Orderline(material_id,order_id,quantity,description);
        cart.add(orderline);

        session.setAttribute("cart",cart);
        request.setAttribute("cartsize",cart.getOrderlineSize());
        request.setAttribute("totalprice",totalPrice);

        request.getRequestDispatcher("myOrders.jsp").forward(request,response);
    }
}
