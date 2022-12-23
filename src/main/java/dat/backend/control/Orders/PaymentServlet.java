package dat.backend.control.Orders;


import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Essentials.Orders;
import dat.backend.model.entities.Essentials.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.Orders.OrdersFacade;
import dat.backend.model.persistence.Orders.OrdersMapper;
import dat.backend.model.persistence.User.UserFacade;
import dat.backend.model.persistence.User.UserMapper;
import dat.backend.model.services.Calculator;
import dat.backend.model.services.SVG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/paymentservlet")
public class PaymentServlet extends HttpServlet {
    ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        int length = (int) session.getAttribute("length");
        int width = (int) session.getAttribute("width");
        int shed = (int) session.getAttribute("shed");
        int shedLength = (int) session.getAttribute("shedLength");
        int shedWidth = (int) session.getAttribute("shedWidth");

        if(shed==0)
        {
            shedLength=0;
            shedWidth=0;
        }

        List<BuildingMaterial> buildingMaterialList = Calculator.billOfMaterialListCreater(length, width, shed, shedLength, shedWidth);
        int price = Calculator.priceCalc(buildingMaterialList);
        Orders orders = new Orders(user.getUser_id(),width,length,price);
        try
        {
            OrdersMapper.createOrders(user, orders, connectionPool);
            session.setAttribute("price", price);
            session.setAttribute("billOfMaterials", buildingMaterialList);
        }
        catch (DatabaseException e)
        {
            e.printStackTrace();
        }
        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }
}
