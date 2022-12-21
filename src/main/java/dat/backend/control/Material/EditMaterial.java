package dat.backend.control.Material;

import dat.backend.model.entities.BuildingMaterial;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

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

        int material_id = Integer.parseInt(request.getParameter("material_id"));

        session.setAttribute("material", materialList.get(material_id-1));

        request.getRequestDispatcher("/WEB-INF/editMaterial.jsp").forward(request, response);
    }
}
