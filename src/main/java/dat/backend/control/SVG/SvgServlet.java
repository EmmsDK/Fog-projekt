package dat.backend.control.SVG;

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
        //carport SVG parameters - not svgDrawing parameters

        double svgWidth = svg.getWidth();
        double svgHeight = svg.getHeight();

        double beamThickness = 5;
        double shed = svg.getShed();
        double shedLength = svg.getShedLength();
        double shedWidth = svg.getShedWidth();
        double onePercentWidth = (svgWidth / 100);
        int beamDistance = Calculator.calcBeamDist((int) svgWidth);
        double dashArrayX2 = svgWidth;
        double middleBeamX = ((onePercentWidth * 20 + (svgWidth - beamThickness * 2 - 15)) / 2);
        boolean notOverlapping = (Math.abs(middleBeamX - (svgWidth - beamThickness - shedLength - 15)) >= 12 || shed == 0) && svgWidth >= 400;

        SVG svgDrawing = CarportSVG.createNewSVG(0, 0, 50, 50, "0 0 " + svgWidth*2  + " " + svgHeight*2);
        SVG carport = CarportSVG.createNewSVG(20, 20, 60, 60, "0 0 " + svgWidth + " " + svgHeight);

        svgDrawing.addArrows(svgHeight);
        svgDrawing.addLines(svgHeight);
        svgDrawing.addMeasurementLines(svgWidth, beamDistance);
        svgDrawing.addBeamMeasurements(svgWidth, svgHeight, beamDistance);
        svgDrawing.addArrowText(svgWidth, svgHeight);

        int fixedOffSet = 30;

        //Updates dasharray lines positional x2 value, if shed is chosen
        if (shed == 1) {
            dashArrayX2 = svgWidth - beamThickness / 2 - shedLength - 15;
        }

        //Vertical rects
        carport.addRect(0, 0, svgHeight, beamThickness);
        carport.addRect(svgWidth - beamThickness, 0, svgHeight, beamThickness);

        //Horizontal rects
        carport.addRect(beamThickness, fixedOffSet, beamThickness, svgWidth - beamThickness * 2);
        carport.addRect(beamThickness, svgHeight - beamThickness - fixedOffSet, beamThickness, svgWidth - beamThickness * 2);

        //Shed builder (0=no shed, 1=shed)
        if (shed == 1) {
            double innerHeight = shedWidth - (beamThickness + fixedOffSet) * 2;
            double middleY = ((shedWidth - fixedOffSet - beamThickness - 1) + (fixedOffSet - 1)) / 2;

            //Vertical rects, left to right
            carport.addRect(svgWidth - beamThickness - shedLength - 15, fixedOffSet + beamThickness, innerHeight, beamThickness);
            carport.addRect(svgWidth - beamThickness * 2 - 15, fixedOffSet + beamThickness, innerHeight, beamThickness);

            //Horizontal rects, top to bottom
            carport.addRect(svgWidth - beamThickness - shedLength - 15, fixedOffSet, beamThickness, shedLength);
            carport.addRect(svgWidth - beamThickness - shedLength - 15, shedWidth - fixedOffSet - beamThickness, beamThickness, shedLength);

            //Squares left side, top to bottom
            carport.addSquare(svgWidth - beamThickness - shedLength - 15 - 1, fixedOffSet - 1);
            carport.addSquare(svgWidth - beamThickness - shedLength - 15 - 1, middleY);
            carport.addSquare(svgWidth - beamThickness - shedLength - 15 - 1, shedWidth - fixedOffSet - beamThickness - 1);

            //Squares right side
            carport.addSquare(svgWidth - beamThickness * 2 - 15 - 1, middleY);
            carport.addSquare(svgWidth - beamThickness * 2 - 15 - 1, shedWidth - fixedOffSet - beamThickness - 1);

        }

        //Squares top row, left to right
        carport.addSquare(onePercentWidth * 20, fixedOffSet - 1);
        if (notOverlapping) {
            carport.addSquare(middleBeamX, fixedOffSet - 1);
        }
        carport.addSquare(svgWidth - beamThickness * 2 - 15 - 1, fixedOffSet - 1);


        //Squares bottom row, left to right
        carport.addSquare(onePercentWidth * 20, svgHeight - beamThickness - fixedOffSet - 1);
        if (shedWidth == svgHeight && notOverlapping || shedWidth != svgHeight) {
            carport.addSquare(middleBeamX, svgHeight - beamThickness - fixedOffSet - 1);
        }
        if (shedWidth != svgHeight) {
            carport.addSquare(svgWidth - beamThickness * 2 - 15 - 1, svgHeight - beamThickness - fixedOffSet - 1);
        }

        carport.addDashArrayLines(onePercentWidth * 10 + beamThickness / 2, dashArrayX2, fixedOffSet, svgHeight - fixedOffSet);

        carport.addBeams(beamDistance, svgHeight, svgWidth);
        carport.addFrame();

        svgDrawing.addInnerSvg(carport);

        request.setAttribute("svg", svgDrawing);
        request.getRequestDispatcher("dealInfo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
