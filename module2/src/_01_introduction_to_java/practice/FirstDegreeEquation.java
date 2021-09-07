package _01_introduction_to_java.practice;

import java.util.Scanner;

public class FirstDegreeEquation {
    public static void main(String[] args) {
        System.out.print("Solve first degree equation: ");
        System.out.println("ax + b = c");
        System.out.println("please enter constains:");
        Scanner sc = new Scanner(System.in);
        System.out.println("a: ");
        double a = Double.parseDouble(sc.nextLine());
        System.out.println("b: ");
        double b = Double.parseDouble(sc.nextLine());
        System.out.println("c: ");
        double c = Double.parseDouble(sc.nextLine());
        double x;
        if(a!=0){
            x = (c-b)/a;
            System.out.println("Equation pass with x = " + x);
        }
        else{
            if(b == c){
                System.out.println("The equation has infinitely many solutions");
            }
            else{
                System.out.println("The equation has no solution");
            }
        }
    }
}
