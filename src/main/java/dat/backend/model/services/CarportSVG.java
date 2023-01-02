package dat.backend.model.services;

public class CarportSVG {
    public static SVG createNewSVG(double x, double y, double height, double width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }
}
