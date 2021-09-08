package _05_access_modifier_and_static.exercise.AccessModifier;

public class Circle {
    private double radius = 1.0d;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle() {
    }

    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.pow(radius,2)*Math.PI;
    }

}
