package dat.backend.control.Material;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.persistence.BuildingMaterial.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static dat.backend.control.Basic.Admin.materialList;
import static dat.backend.model.persistence.Orders.OrdersMapper.connectionPool;

@WebServlet(name = "UpdateMaterial", value = "/updatematerial")
public class UpdateMaterial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        //List<BuildingMaterial> materialList = (List<BuildingMaterial>) session.getAttribute("materialList");

        int material_id = Integer.parseInt(request.getParameter("material_id"));
        int length;
        int price;
        String type = request.getParameter("type");
        String description = request.getParameter("description");

        if (type.equals("")) {
            type = materialList.get(material_id - 1).getType();
        }
        if (description.equals("")) {
            description = materialList.get(material_id - 1).getDescription();
        }

        try {
            length = Integer.parseInt(request.getParameter("length"));
        } catch (NumberFormatException e) {
            length = materialList.get(material_id - 1).getLength();
        }

        try {
            price = Integer.parseInt(request.getParameter("price"));
        } catch (NumberFormatException e) {
            price = materialList.get(material_id - 1).getPrice();
        }

        BuildingMaterialFacade.updateMaterial(material_id, type, description, length, price, connectionPool);

        session.setAttribute("materialList", BuildingMaterialFacade.getAllMaterials());

        request.getRequestDispatcher("materialList.jsp").forward(request, response);
    }
}
