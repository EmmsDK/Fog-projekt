package dat.backend.control;

import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;
import dat.backend.model.services.Calculator;

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
        double svgWidth = svg.getWidth();
        double svgHeight = svg.getHeight();
        double beamThiccness = 10;
        double shed = svg.getShed();
        double shedLength = svg.getShedLength();
        double shedWidth = svg.getShedWidth();
        double onePercentWidth = (svgWidth / 100);
        double onePercentHeight = (svgHeight / 100);

        int orderID = 34;
        //Order order = orderFacade.getOrderById(orderID);


        SVG carport = CarportSVG.createNewSVG(0, 0, 35, 35, "0 0 " + svgWidth + " " + svgHeight);
        int fixedOffSet = 30;

        carport.addDashArrayLines(onePercentWidth * 10, svgWidth, fixedOffSet, svgHeight - onePercentHeight - fixedOffSet);

        //Vertical rects
        carport.addRect(0, 0, svgHeight, beamThiccness);
        carport.addRect(svgWidth - beamThiccness, 0, svgHeight, beamThiccness);

        //Horizontal rects
        carport.addRect(beamThiccness, fixedOffSet, beamThiccness, svgWidth - beamThiccness * 2);
        carport.addRect(beamThiccness, svgHeight - beamThiccness - fixedOffSet, beamThiccness, svgWidth - beamThiccness * 2);

        //Shed builder (0=no shed, 1=shed)
        if (shed == 1) {
            double innerHeight = shedWidth - (beamThiccness + fixedOffSet) * 2;
            double middleY = ((shedWidth - fixedOffSet - beamThiccness - 1) + (fixedOffSet - 1)) / 2;

            //Vertical rects, left to right
            carport.addRect(svgWidth - beamThiccness - shedLength - 15, fixedOffSet + beamThiccness, innerHeight, beamThiccness);
            carport.addRect(svgWidth - beamThiccness * 2 - 15, fixedOffSet + beamThiccness, innerHeight, beamThiccness);

            //Horizontal rects, top to bottom
            carport.addRect(svgWidth - beamThiccness - shedLength - 15, fixedOffSet, beamThiccness, shedLength);
            carport.addRect(svgWidth - beamThiccness - shedLength - 15, shedWidth - fixedOffSet - beamThiccness, beamThiccness, shedLength);

            //Squares left side, top to bottom
            carport.addSquare(svgWidth - beamThiccness - shedLength - 15 - 1, fixedOffSet - 1);
            carport.addSquare(svgWidth - beamThiccness - shedLength - 15 - 1, middleY);
            carport.addSquare(svgWidth - beamThiccness - shedLength - 15 - 1, shedWidth - fixedOffSet - beamThiccness - 1);

            //Squares right side
            carport.addSquare(svgWidth - beamThiccness * 2 - 15 - 1, middleY);
            carport.addSquare(svgWidth - beamThiccness * 2 - 15 - 1, shedWidth - fixedOffSet - beamThiccness - 1);

        }

        //Squares top row, left to right
        if (Math.abs((onePercentWidth * 20)-(svgWidth - beamThiccness - shedLength - 15))>=12||shed==0) {
            carport.addSquare(onePercentWidth * 20, fixedOffSet - 1);
        }
        if (Math.abs((onePercentWidth * 55)-(svgWidth - beamThiccness - shedLength - 15))>=12||shed==0) {
            carport.addSquare(onePercentWidth * 55, fixedOffSet - 1);
        }
        carport.addSquare(svgWidth - beamThiccness * 2 - 15 - 1, fixedOffSet - 1);


        //Squares bottom row, left to right
        carport.addSquare(onePercentWidth * 20, svgHeight - beamThiccness - fixedOffSet - 1);
        carport.addSquare(onePercentWidth * 55, svgHeight - beamThiccness - fixedOffSet - 1);

        if (shedWidth != svgHeight) {
            carport.addSquare(svgWidth - beamThiccness * 2 - 15 - 1, svgHeight - beamThiccness - fixedOffSet - 1);
        }
        int beamDistance=Calculator.calcBeamDist((int) svgWidth);
        carport=CarportSVG.addBeams(carport, beamDistance);

        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
