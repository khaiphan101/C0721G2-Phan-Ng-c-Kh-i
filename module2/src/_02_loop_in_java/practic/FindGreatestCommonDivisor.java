package _02_loop_in_java.practic;

import java.util.Scanner;

public class FindGreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a: ");
        int a = Math.abs(sc.nextInt());
        System.out.println("enter b: ");
        int b = Math.abs(sc.nextInt());
        if(a == 0 || b == 0) {
            System.out.println("No greatest common divisor");
        }
        else {
            while(a!=b) {
                if(a>b)
                    a = a - b;
                else
                    b = b - a;
            }
            System.out.println("Greatest common divisor: " + a);
        }

    }
}
