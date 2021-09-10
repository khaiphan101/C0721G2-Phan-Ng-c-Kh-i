package _07_abstract_class_and_interface.exercise.interface_colorable;



public class Rectangle extends Shape {
    private double width = 1.0d;
    private double length = 1.0d;
    private double area =  width * length;
    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, Boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
        area =  width * length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
        area =  width * length;
    }

    public void getArea() {
        System.out.println("Area = " + area);
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and length="
                + getLength()
                + ", which is a subclass of "
                + super.toString();
    }

}
