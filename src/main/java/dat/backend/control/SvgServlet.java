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
        double width = svg.getWidth();
        double height = svg.getHeight();
        double beamThiccness=8;
        double shed = svg.getShed();
        double shedLength = svg.getShedLength();
        double shedWidth = svg.getShedWidth();
        double onePercentWidth=(width/100);
        double onePercentHeight=(height/100);

        int orderID = 34;
        //Order order = orderFacade.getOrderById(orderID);


        SVG carport = CarportSVG.createNewSVG(0, 0, 35, 35, "0 0 "+width+" "+height);
        //carport = CarportSVG.addBeams(carport);
        int fixedOffSet = 30;

        carport.addDashArrayLines(onePercentWidth*10, width, fixedOffSet, height-onePercentHeight-fixedOffSet);

        //Vertical rects
        carport.addRect(0,0,height,beamThiccness);
        carport.addRect(width-beamThiccness,0,height,beamThiccness);

        //Horizontal rects
        carport.addRect(beamThiccness,fixedOffSet,beamThiccness, width-beamThiccness*2);
        carport.addRect(beamThiccness,height-beamThiccness-fixedOffSet,beamThiccness, width-beamThiccness*2);

        //Squares top row, left to right
        carport.addSquare(onePercentWidth * 20, fixedOffSet-1);
        carport.addSquare(onePercentWidth * 55, fixedOffSet-1);
        carport.addSquare(onePercentWidth * 80, fixedOffSet-1);

        //Squares bottom row, left to right
        carport.addSquare(onePercentWidth * 20, height-beamThiccness-fixedOffSet-1);
        carport.addSquare(onePercentWidth * 55, height-beamThiccness-fixedOffSet-1);
        carport.addSquare(onePercentWidth * 80, height-beamThiccness-fixedOffSet-1);

        //Shed builder (0=no shed, 1=shed)
        if (shed==1)
        {
            double innerHeight=height-(beamThiccness+fixedOffSet)*2;

            //Vertical rects, left to right
            carport.addRect(width-beamThiccness*2-shedLength-15,fixedOffSet+beamThiccness,innerHeight, beamThiccness);
            carport.addRect(width-onePercentWidth*5-15,fixedOffSet+beamThiccness,innerHeight,beamThiccness);

            //Horizontal rects, top to bottom
            carport.addRect(width-beamThiccness*2-shedLength-15,fixedOffSet,2,shedLength);
            carport.addRect(width-beamThiccness*2-shedLength-15,shedWidth-fixedOffSet-2*onePercentHeight,2,shedLength);
        }


        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
