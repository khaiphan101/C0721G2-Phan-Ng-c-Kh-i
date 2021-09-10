package _06_inherit.exercise.class_circle_and_class_cylinder;

public class Circle {
    private double radius = 1.0d;
    private String color = "green";
    private double area =  radius * radius * Math.PI;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        area =  getRadius()* getRadius() * Math.PI;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        area =  getRadius()* getRadius() * Math.PI;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return this.area;
    }

    @Override
    public String toString() {
        return "A Circle with radius = " + getRadius() + ", color " + color + " and area = " + getArea();
    }
}
