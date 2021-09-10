package _07_abstract_class_and_interface.exercise.interface_colorable;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        shapes[3] = new Circle();
        for (Shape shape : shapes) {
            System.out.println(shape);
            shape.getArea();
            if (shape instanceof Colorable){
                ((Colorable) shape).howToColor();
            }
        }
    }
}
