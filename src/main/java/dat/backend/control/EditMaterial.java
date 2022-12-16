package dat.backend.control;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.persistence.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static dat.backend.model.persistence.OrdersMapper.connectionPool;

@WebServlet(name = "EditMaterial", value = "/editmaterial")
public class EditMaterial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();

        List<BuildingMaterial> materialList = (List<BuildingMaterial>) session.getAttribute("materialList");
        /*
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        OrdersFacade.removeOrder(order_id,connectionPool);
        List<Orders> ordersList = (List<Orders>) session.getAttribute("ordersList");
        ordersList.removeIf(orders -> orders.getOrder_id()==order_id);
         */

        int material_id = Integer.parseInt(request.getParameter("material_id"));
        int length = materialList.get(material_id-1).getLength();
        int type_id = materialList.get(material_id-1).getType_id();
        int price = materialList.get(material_id-1).getPrice();
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        BuildingMaterialFacade.updateMaterial(material_id,type, description, length, type_id, price,connectionPool);

        request.setAttribute("materialList", materialList);
        request.getRequestDispatcher("/WEB-INF/editMaterial.jsp").forward(request, response);
    }
}
