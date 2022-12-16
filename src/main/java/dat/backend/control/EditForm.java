package dat.backend.control;

import dat.backend.model.entities.Material;
import dat.backend.model.persistence.BuildingMaterialFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import static dat.backend.model.persistence.OrdersMapper.connectionPool;

@WebServlet(name = "EditForm", value = "/editform")
public class EditForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int item_id = Integer.parseInt(request.getParameter("item_id"));
        Material material = BuildingMaterialFacade.getMaterialById(item_id, connectionPool);
        request.setAttribute("material", material);
        request.getRequestDispatcher("WEB-INF/editMaterial.jsp").forward(request, response);
    }
}
