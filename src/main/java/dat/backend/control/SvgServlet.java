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
        int shed = svg.getShed();
        int shedLength = svg.getShedLength();
        int shedWidth = svg.getShedWidth();
        int onePercentWidth=(width/100);
        int onePercentHeight=(height/100);

        int orderID = 34;
        //Order order = orderFacade.getOrderById(orderID);


        SVG carport = CarportSVG.createNewSVG(0, 0, 35, 35, "0 0 "+width+" "+height);
        //carport = CarportSVG.addBeams(carport);
        int fixedOffSet = 30;

        carport.addDashArrayLines(onePercentWidth*10, width, fixedOffSet, height-onePercentHeight-fixedOffSet);

        //Vertical rects
        carport.addRect(0,0,100,1);
        carport.addRect(width-onePercentWidth,0,100,1);

        //Horizontal rects
        carport.addRect(width/100,fixedOffSet,1, 98);
        carport.addRect(width/100,height-onePercentHeight-fixedOffSet,1, 98);

        //Squares top row, left to right
        carport.addSquare(onePercentWidth * 20, fixedOffSet * 88.3 / 100);
        carport.addSquare(onePercentWidth * 55, fixedOffSet * 88.3 / 100);
        carport.addSquare(onePercentWidth * 80, fixedOffSet * 88.3 / 100);

        //Squares bottom row, left to right
        carport.addSquare(onePercentWidth * 20, height-10-(fixedOffSet * 88.3 / 100));
        carport.addSquare(onePercentWidth * 55, height-10-(fixedOffSet * 88.3 / 100));
        carport.addSquare(onePercentWidth * 80, height-10-(fixedOffSet * 88.3 / 100));

        //Shed builder (0=no shed, 1=shed)
        if (shed==1)
        {
            int innerHeight= (100*(shedWidth-fixedOffSet*2))/height;
            int innerLength= 100*shedLength/width;

            //Vertical rects, left to right
            carport.addRect(width-onePercentWidth*2-shedLength-15,fixedOffSet,innerHeight,2);
            carport.addRect(width-onePercentWidth*5-15,fixedOffSet,innerHeight,2);

            //Horizontal rects, top to bottom
            carport.addRect(width-onePercentWidth*2-shedLength-15,fixedOffSet,2,innerLength);
            carport.addRect(width-onePercentWidth*2-shedLength-15,shedWidth-fixedOffSet-2*onePercentHeight,2,innerLength);
        }


        request.setAttribute("svg", carport.toString());
        request.getRequestDispatcher("WEB-INF/svgdrawing.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
