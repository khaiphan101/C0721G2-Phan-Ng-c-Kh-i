package _06_inherit.practic.shapes;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        System.out.println("area of circle: " + circle.getArea());
        circle = new Circle(3.5);
        System.out.println(circle);
        System.out.println("area of circle: " + circle.getArea());
        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
        System.out.println("area of circle: " + circle.getArea());
    }
}
