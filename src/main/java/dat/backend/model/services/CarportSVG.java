package dat.backend.model.services;

public class CarportSVG {
    public static SVG createNewSVG(double x, double y, double height, double width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static void addBeams(SVG svg, int beamDistance) {
        double svgWidth = svg.getWidth();
        double svgHeight= svg.getHeight();

        for (int i = 0; i < (int)svgWidth; i += beamDistance) {
            svg.addRect(i, 0, svgHeight, 5);
        }

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
