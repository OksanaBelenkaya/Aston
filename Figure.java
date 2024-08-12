
public class Figure {

    public static void main(String[] args) {

        Shape rectangle = new Rectangle(10, 12, "Red", "Blue");
        Shape circle = new Circle(5, "Yellow", "Purple");
        Shape triangle = new Triangle(5, 9, 12, "White", "Green");
        System.out.println("Площадь и периметр фигур: ");
        System.out.println("1.Прямоугольник: Length-10, Width-12");
        System.out.println("Площадь: " + rectangle.getArea());
        System.out.println("Периметр: " + rectangle.getPerimeter());
        System.out.println("Цвет фона: " + rectangle.backgroundColor());
        System.out.println("Цвет границы: " + rectangle.borderColor());
        System.out.println("2.Круг: Radius-5");
        System.out.println("Площадь: " + circle.getArea());
        System.out.println("Периметр: " + circle.getPerimeter());
        System.out.println("Цвет фона: " + rectangle.backgroundColor());
        System.out.println("Цвет границы: " + rectangle.borderColor());
        System.out.println("3.Треугольник: Sid2-4, Sid2-6, Sid2-8");
        System.out.println("Площадь: " + triangle.getArea());
        System.out.println("Периметр: " + triangle.getPerimeter());
        System.out.println("Цвет фона: " + rectangle.backgroundColor());
        System.out.println("Цвет границы: " + rectangle.borderColor());
    }
}
