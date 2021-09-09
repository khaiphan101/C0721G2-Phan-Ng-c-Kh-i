package _06_inherit.practic.shapes;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        System.out.println("area of rectangle: " + rectangle.getArea());
        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        System.out.println("area of rectangle: " + rectangle.getArea());
        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);
        System.out.println("area of rectangle: " + rectangle.getArea());
    }
}
