package _06_inherit.exercise.class_circle_and_class_cylinder;

public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5.0d);
        System.out.println(cylinder);
    }
}
