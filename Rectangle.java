
public class Rectangle implements Shape {

    final private double length;
    final private double width;
    final private String backgroundColor;
    final private String borderColor;

    public Rectangle(double length, double width, String backgroundColor, String borderColor) {
        this.length = length;
        this.width = width;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
    }

    public double getArea() {

        return length * width;
    }

    public double getPerimeter() {
        return 2 * (length + width);
    }

    public String backgroundColor() {
        return backgroundColor;
    }

    public String borderColor() {
        return borderColor;
    }
}
