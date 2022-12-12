package dat.backend.control;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.services.SVG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "buildACarport", value = "/buildacarport")
public class BuildACarport extends HttpServlet {

    private static ConnectionPool connectionPool = new ConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SVG svg = new SVG();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("type carport"));
        svg.setWidth(length);
        svg.setHeight(width);
        session.setAttribute("svg", svg);
        request.getRequestDispatcher("buildACarport.jsp").forward(request, response);
    }
}