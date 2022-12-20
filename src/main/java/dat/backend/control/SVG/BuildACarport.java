package dat.backend.control.SVG;

import dat.backend.model.services.SVG;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;


@WebServlet(name = "buildACarport", value = "/buildacarport")
public class BuildACarport extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        SVG svg = new SVG();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int shed = Integer.parseInt(request.getParameter("shed"));
        int shedLength = Integer.parseInt(request.getParameter("shedLength"));
        int shedWidth = Integer.parseInt(request.getParameter("shedWidth"));
        svg.setWidth(length);
        svg.setHeight(width);
        svg.setShed(shed);
        svg.setShedLength(shedLength);
        svg.setShedWidth(shedWidth);
        session.setAttribute("svg", svg);
        request.getRequestDispatcher("buildACarport.jsp").forward(request, response);
    }
}