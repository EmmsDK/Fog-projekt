package dat.backend.control.Material;

import dat.backend.model.entities.Materials.Material;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.BuildingMaterial.BuildingMaterialFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddMaterial", value = "/addmaterial")
public class AddMaterial extends HttpServlet {

    private static final ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String type = request.getParameter("type");
        String description = request.getParameter("description");
        int length = Integer.parseInt(request.getParameter("length"));
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        int price = Integer.parseInt(request.getParameter("price"));

        HttpSession session;

        try {
            Material createMaterial = BuildingMaterialFacade.createMaterial(type, description, length, type_id, price, connectionPool);

            session = request.getSession();
            session.setAttribute("createMaterial", createMaterial);
            session.setAttribute("materialList", BuildingMaterialFacade.getAllMaterials());

            request.getRequestDispatcher("materialList.jsp").forward(request, response);
        } catch (DatabaseException e) {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
