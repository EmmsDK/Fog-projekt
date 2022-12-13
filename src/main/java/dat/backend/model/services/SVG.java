package dat.backend.model.services;

public class SVG {
    private int x=0;
    private int y=0;
    private int height=100;
    private int width=100;
    private int shed=1;
    private int shedLength=100;
    private int shedWidth=100;



    private String viewbox="0 0 "+width+" "+height;
    private StringBuilder svgString=new StringBuilder();

    private final static String HEADERTEMPLATE = "<svg x=\"%d%%\" y=\"%d%%\" height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final static String RECTTEMPLATE = "<rect x=\"%d\" y=\"%d\" height=\"%f%%\" width=\"%f%%\"fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String SQUARETEMPLATE = "<rect x=\"%f\" y=\"%f\" height=\"%d\" width=\"%d\" fill=\"#ffffff\" stroke=\"#8b8878\"/>";
    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";
    private final static String DASHARRAYTEMPLATE =
            "<line fill=\"none\" stroke=\"black\" stroke-dasharray=\"0.5%%,0.5%%\" x1=\"%d\" x2=\"%d\" y1=\"%d\" y2=\"%d\" />\n";

    public SVG(int x, int y, int height, int width, String viewbox) {
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
    public void addRect(int x, int y, double height, double width){
    svgString.append(String.format(RECTTEMPLATE,x,y,height,width));
    }
    public void addSquare(double x, double y){
        svgString.append(String.format(SQUARETEMPLATE,x,y,10,10));
    }

    public void addDashArrayLines(int x1, int x2, int y1, int y2)
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getShed() {
        return shed;
    }

    public void setShed(int shed) {
        this.shed = shed;
    }

    public int getShedLength() {
        return shedLength;
    }

    public void setShedLength(int shedLength) {
        this.shedLength = shedLength;
    }

    public int getShedWidth() {
        return shedWidth;
    }

    public void setShedWidth(int shedWidth) {
        this.shedWidth = shedWidth;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
