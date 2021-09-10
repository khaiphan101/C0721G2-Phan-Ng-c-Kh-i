package _07_abstract_class_and_interface.exercise.interface_colorable;

public class Square extends Rectangle implements Colorable {
    private double area =  getSide() * getSide();

    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
        area =  getSide() * getSide();
    }

    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public void getArea() {
        System.out.println("Area = " + area);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}

