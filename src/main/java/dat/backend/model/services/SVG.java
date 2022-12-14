package dat.backend.model.services;

public class SVG {
    private double x=0;
    private double y=0;
    private double height=100;
    private double width=100;
    private double shed=1;
    private double shedLength=100;
    private double shedWidth=100;



    private String viewbox="0 0 "+width+" "+height;
    private StringBuilder svgString=new StringBuilder();

    private final static String HEADERTEMPLATE = "<svg x=\"%f%%\" y=\"%f%%\" height=\"%f%%\" width=\"%f%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final static String RECTTEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\"fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String SQUARETEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%f\" width=\"%f\" fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final static String DASHARRAYTEMPLATE =
            "<line fill=\"none\" stroke=\"black\" stroke-dasharray=\"0.5%%,0.5%%\" x1=\"%f\" x2=\"%f\" y1=\"%f\" y2=\"%f\" />\n";

    public SVG(double x, double y, double height, double width, String viewbox) {
        svgString.append(String.format(HEADERTEMPLATE, x,y, height, width, viewbox));
        svgString.append(ARROWHEADSTEMPLATE);
        this.x=x;
        this.y=y;
        this.height = height;
        this.width = width;
        this.viewbox = viewbox;
    }

    public SVG() {
    }

    //<rect x="55" y="0" height="600" width="5"
    public void addRect(double x, double y, double height, double width){
    svgString.append(String.format(RECTTEMPLATE,x,y,height,width));
    }
    public void addSquare(double x, double y){
        svgString.append(String.format(SQUARETEMPLATE,x,y,10.0,10.0));
    }

    public void addDashArrayLines(double x1, double x2, double y1, double y2)
    {
        svgString.append(String.format(DASHARRAYTEMPLATE,x1,x2,y1,y2));
        svgString.append(String.format(DASHARRAYTEMPLATE,x2,x1,y1,y2));
    }

    public void addLine(int x1, int y1, int x2, int y2){

    }

    public void addInnerSvg(SVG innerSVGDrawing){
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
