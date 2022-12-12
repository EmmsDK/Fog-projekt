package dat.backend.control;

import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "SvgServlet", value = "/svg")
public class SvgServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        SVG svg = (SVG) session.getAttribute("svg");
        int width = svg.getWidth();
        int height = svg.getHeight();

        int orderID = 34;
        //Order order = orderFacade.getOrderById(orderID);


        SVG carport = CarportSVG.createNewSVG(0, 0, 35, 35, "0 0 "+width+" "+height);
        //carport = CarportSVG.addBeams(carport);
        int fixedOffSet = 30;
        carport.addDashArrayLines((width/100)*15, width, fixedOffSet, height-(height/100)-fixedOffSet);
        carport.addRect(0,0,100,1);
        carport.addRect(width-(width/100),0,100,1);
        carport.addRect(0,0+fixedOffSet,1, 100);
        carport.addRect(0,height-(height/100)-fixedOffSet,1, 100); //-(height/100) for at gøre op for rem bredden

        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
