package _06_inherit.practic.shapes;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        System.out.println("area of square: " + square.getArea());
        square = new Square(2.3);
        System.out.println(square);
        System.out.println("area of square: " + square.getArea());
        square = new Square(5.8, "yellow", true);
        System.out.println(square);
        System.out.println("area of square: " + square.getArea());
    }
}
