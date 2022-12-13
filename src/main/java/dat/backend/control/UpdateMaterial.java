package dat.backend.control;

import dat.backend.model.entities.BuildingMaterial;
import dat.backend.model.persistence.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import static dat.backend.model.persistence.OrdersMapper.connectionPool;

@WebServlet(name = "UpdateMaterial", value = "/updatematerial")
public class UpdateMaterial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        int material_id = Integer.parseInt(request.getParameter("material_id"));
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        int length = Integer.parseInt(request.getParameter("length"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        BuildingMaterialFacade.updateMaterial(material_id, type, description, length, type_id, connectionPool);
        List<BuildingMaterial> materialList = BuildingMaterialFacade.getDynamicMaterials(connectionPool);
        request.setAttribute("materialList", materialList);
        request.getRequestDispatcher("WEB-INF/welcome.jsp").forward(request, response);
    }
}
