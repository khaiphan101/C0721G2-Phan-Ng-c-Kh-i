package _06_inherit.exercise.class_circle_and_class_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(2.0d, "red");
        System.out.println(circle);
    }
}
