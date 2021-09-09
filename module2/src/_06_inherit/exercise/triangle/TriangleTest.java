package _06_inherit.exercise.triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Triangle");
        System.out.print("Enter side1:");
        double side1 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter side2:");
        double side2 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter side2:");
        double side3 = Double.parseDouble(sc.nextLine());
        System.out.print("Enter color:");
        String color = sc.nextLine();
        Triangle triangle = new Triangle(color, true, side1, side2, side3);
        System.out.println(triangle);
    }
}
