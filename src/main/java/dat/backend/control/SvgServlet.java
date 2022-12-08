package dat.backend.control;

import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "SvgServlet", value = "/svg")
public class SvgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        int orderID = 34;
        //Order order = orderFacade.getOrderById(orderID);


        SVG carport = CarportSVG.createNewSVG(0,0,100,100,"0 0 855 690");
        carport = CarportSVG.addBeams(carport);
        //carport = CarportSVG.addDashArrayLines(carport,855,690);
        carport.addDashArrayLines(0,855,0,690);

        request.setAttribute("svg",carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
