
public class Circle implements Shape {

    final private double radius;
    final private String backgroundColor;
    final private String borderColor;

    public Circle(int radius, String backgroundColor, String borderColor) {
        this.radius = radius;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;

    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public String backgroundColor() {
        return backgroundColor;
    }

    public String borderColor() {
        return borderColor;
    }

}
