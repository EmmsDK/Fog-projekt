package dat.backend.model.services;

public class SVG {
    private double x;
    private double y;
    private double height;
    private double width;
    private double shed;
    private double shedLength;
    private double shedWidth;


    private String viewbox = "0 0 " + width + " " + height;
    private StringBuilder svgString = new StringBuilder();

    private final static String HEADERTEMPLATE = "<svg x=\"%f%%\" y=\"%f%%\" height=\"%f%%\" width=\"%f%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin meet\">";
    private final static String RECTTEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String FRAMETEMPLATE = "<rect x=\"0%\" y=\"0%\" height=\"100%\" width=\"100%\" fill=\"none\" stroke-width=\"3\" stroke=\"#8b8878\"/>";
    private final static String TEXTTEMPLATE = "<text style=\"text-anchor: middle \" transform=\"translate(%f, %f) rotate(%d)\">%s</text>";
    private final static String LINETEMPLATE = "<line x1=\"%f%%\"  y1=\"%f%%\" x2=\"%f%%\"   y2=\"%f%%\" stroke=\"#006600\"/>";
    private final static String BEAMTEMPLATE = "<rect x=\"%f\" y=\"0\" height=\"%f\" width=\"5\"fill=\"#ffffff\" stroke-width=\"2\" stroke=\"#8b8878\"/>";
    private final static String SQUARETEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final static String ARROWSTEMPLATE = "<line x1=\"%f%%\"  y1=\"%f%%\" x2=\"%f%%\"   y2=\"%f%%\" style=\"stroke: #006600; marker-start: url(#beginArrow); marker-end: url(#endArrow);\"/>";
    private final static String DASHARRAYTEMPLATE =
            "<line fill=\"none\" stroke=\"black\" stroke-dasharray=\"0.5%%,0.5%%\" x1=\"%f\" x2=\"%f\" y1=\"%f\" y2=\"%f\" />\n";

    public SVG(double x, double y, double height, double width, String viewbox) {
        svgString.append(String.format(HEADERTEMPLATE, x, y, height, width, viewbox));
        svgString.append(ARROWHEADSTEMPLATE);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public SVG() {
    }

    //<rect x="55" y="0" height="600" width="5"
    public void addRect(double x, double y, double height, double width) {
        svgString.append(String.format(RECTTEMPLATE, x, y, height, width));
    }

    public void addFrame() {
        svgString.append(FRAMETEMPLATE);
    }

    public void addSquare(double x, double y) {
        svgString.append(String.format(SQUARETEMPLATE, x, y, 7.0, 7.0));
    }

    public void addDashArrayLines(double x1, double x2, double y1, double y2) {
        svgString.append(String.format(DASHARRAYTEMPLATE, x1, x2, y1, y2));
        svgString.append(String.format(DASHARRAYTEMPLATE, x2, x1, y1, y2));
    }

    public void addBeams(int beamDistance, double height, double width) {

        for (int i = 0; i < width - 5; i += beamDistance) {
            svgString.append(String.format(BEAMTEMPLATE, (double) i + 1, height));
        }
        svgString.append(String.format(BEAMTEMPLATE, width - 6, height));
    }

    public void addArrow(double x1, double y1, double x2, double y2) {
        svgString.append(String.format(ARROWSTEMPLATE, x1, y1, x2, y2));
    }

    public void addArrows(double svgHeight) {
        //height
        addArrow(8, 20, 8, 80);

        //inner height
        addArrow(15, 20 + (19 / svgHeight * 100), 15, 80 - (19 / svgHeight * 100));

        //width
        addArrow(20, 87.5, 80, 87.5);
    }

    public void addLine(double x1, double y1, double x2, double y2) {
        svgString.append(String.format(LINETEMPLATE, x1, y1, x2, y2));
    }

    public void addLines(double svgHeight) {
        //full-height arrow
        addLine(5.5, 20, 10.5, 20);
        addLine(5.5, 80, 10.5, 80);

        //inner-height arrow
        addLine(12.5, 20 + (19 / svgHeight * 100), 17.5, 20 + (19 / svgHeight * 100));
        addLine(12.5, 80 - (19 / svgHeight * 100), 17.5, 80 - (19 / svgHeight * 100));

        //width arrow
        addLine(20, 85, 20, 90);
        addLine(80, 85, 80, 90);

    }

    public void addMeasurementLines(double svgWidth, int beamDistance) {
        double xIncrement;
        double amountOfBeams = svgWidth / beamDistance;
        for (double i = 0; i <= amountOfBeams; i++) {
            xIncrement = 20 + (60 / (amountOfBeams) * i);
            addLine(xIncrement, 12.5, xIncrement, 17.5);
        }
    }

    public void addBeamMeasurements(double svgWidth, double svgHeight, int beamDistance) {
        double amountOfBeams = svgWidth / beamDistance;
        double outerSvgWidth = svgWidth * 2;
        double outerSvgHeight = svgHeight * 2;
        for (double i = 0; i < amountOfBeams; i++) {
            addMeasurementText(0.20 * (outerSvgWidth) + (0.6 * ((outerSvgWidth / amountOfBeams)) / 2 + (0.6 * ((outerSvgWidth / amountOfBeams)) * i)), 0.1625 * outerSvgHeight, beamDistance);
        }
    }


    public void addArrowText(double svgWidth, double svgHeight) {
        svgString.append(String.format(TEXTTEMPLATE, 6.5 * svgWidth * 2 / 100, 50.0 * svgHeight * 2 / 100, -90, svgHeight / 100 + "m"));
        svgString.append(String.format(TEXTTEMPLATE, 14 * svgWidth * 2 / 100, 50.0 * svgHeight * 2 / 100, -90, (svgHeight - 70) / 100 + "m"));
        svgString.append(String.format(TEXTTEMPLATE, 50 * svgWidth * 2 / 100, 86.5 * svgHeight * 2 / 100, 0, svgWidth / 100 + "m"));
    }

    public void addMeasurementText(double x, double y, int beamDistance) {
        svgString.append(String.format(TEXTTEMPLATE, x, y, 0, (double) beamDistance / 100));
    }

    public void addInnerSvg(SVG innerSVGDrawing) {
        svgString.append(innerSVGDrawing);
    }

    @Override
    public String toString() {
        return svgString + "</svg>";
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getShed() {
        return shed;
    }

    public void setShed(int shed) {
        this.shed = shed;
    }

    public double getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public double getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
