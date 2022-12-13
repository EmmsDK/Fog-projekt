package dat.backend.control;

import dat.backend.model.entities.Material;
import dat.backend.model.persistence.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static dat.backend.model.persistence.OrdersMapper.connectionPool;

@WebServlet(name = "EditMaterial", value = "/editmaterial")
public class EditMaterial extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int material_id = Integer.parseInt(request.getParameter("material_id"));
        Material material = BuildingMaterialFacade.getMaterialById(material_id, connectionPool);
        request.setAttribute("material", material);
        request.getRequestDispatcher("WEB-INF/edititem.jsp").forward(request, response);
    }
}
