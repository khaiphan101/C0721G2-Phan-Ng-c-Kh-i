package _04_class_and_object.exercise.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a:");
        double a = scanner.nextDouble();
        System.out.print("Enter b:");
        double b = scanner.nextDouble();
        System.out.print("Enter c:");
        double c = scanner.nextDouble();
        QuadraticEquation f = new QuadraticEquation(a, b, c);
        System.out.println(f.toString());
        System.out.println(f.showRoot());
    }


}
