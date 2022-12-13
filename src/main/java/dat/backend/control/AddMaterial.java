package dat.backend.control;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.entities.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static dat.backend.model.persistence.OrdersMapper.connectionPool;

@WebServlet(name = "AddMaterial", value = "/AddMaterial")
public class AddMaterial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        int length = Integer.parseInt(request.getParameter("length"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        HttpSession session = request.getSession();

        try {
            Material newMaterialId = BuildingMaterialFacade.createMaterial(type,description,length,type_id );
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        List<BuildingMaterial> materialList = BuildingMaterialFacade.getDynamicMaterials(connectionPool);
        request.setAttribute("materialList", materialList);
        request.getRequestDispatcher("admin.jsp").forward(request, response);
    }
}
