package dat.backend.model.services;

public class CarportSVG {
    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG addBeams(SVG svg) {

        for (int i = 0; i < 800; i += 50) {
            svg.addRect(i, 0, 600.5, 4.5);

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
