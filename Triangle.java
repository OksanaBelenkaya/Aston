
public class Triangle implements Shape {

    final private double sid1;
    final private double sid2;
    final private double sid3;
    final private String backgroundColor;
    final private String borderColor;

    public Triangle(double sid1, double sid2, double sid3, String backgroundColor, String borderColor) {
        this.sid1 = sid1;
        this.sid2 = sid2;
        this.sid3 = sid3;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public double getArea() {
        double s = (sid1 + sid2 + sid3) / 2;
        return Math.sqrt(s * (s - sid1) * (s - sid2) * (s - sid3));
    }

    public double getPerimeter() {
        return sid1 + sid2 + sid3;
    }

    public String backgroundColor() {
        return backgroundColor;
    }

    public String borderColor() {
        return borderColor;
    }
}
