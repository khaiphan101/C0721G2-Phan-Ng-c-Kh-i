package _06_inherit.exercise.class_circle_and_class_cylinder;

public class Cylinder extends Circle{
    private double height = 3.0d;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }
    @Override
    public String toString() {
        return "Cylinder has " + "height= " + height + ", which is a subclass of " + super.toString() + ", volume = " + getVolume();
    }
}
