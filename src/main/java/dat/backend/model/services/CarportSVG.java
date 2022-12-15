package dat.backend.model.services;

public class CarportSVG {
    public static SVG createNewSVG(double x, double y, double height, double width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG addBeams(SVG svg, int beamDistance) {

        for (int i = 0; i < svg.getWidth(); i += beamDistance) {
            svg.addRect(i, 0, svg.getHeight(), 5);
        }
        return svg;

    }

    //find på bedre navn
    /*
    public static SVG addDashArrayLines(SVG svg, int viewboxWidth,int viewboxHeight) {
        svg.addDashArrayLine(0, viewboxWidth, 0, viewboxHeight);
        svg.addDashArrayLine(0, viewboxWidth, viewboxHeight, 0);
        return svg;
    }

     */


}
