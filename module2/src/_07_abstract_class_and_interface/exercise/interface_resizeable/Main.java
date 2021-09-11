package _07_abstract_class_and_interface.exercise.interface_resizeable;


public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Rectangle();
        shapes[2] = new Square();
        System.out.println("Pre-Resize:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("After-Resize:");
        for (Shape shape : shapes) {
            int percent = (int) (Math.random() * 100);
            System.out.println("Random percent(1-100) = " + percent);
            shape.resize(percent);

//            C2: không dùng Shape đề implement mà dùng các class con implement rồi ép kiểu về lớp con để gọi hàm resize()
//            if (shape instanceof Circle) {
//                Circle circle = (Circle) shape;
//                circle.resize(percent);
//            } else if (shape instanceof Rectangle) {
//                Rectangle rectangle = (Rectangle) shape;
//                rectangle.resize(percent);
//            } else {
//                Square square = (Square) shape;
//                square.resize(percent);
//            }
        }
    }
}
