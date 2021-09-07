package _02_loop_in_java.exercise;

import java.util.Scanner;

public class PrintMenu {
    public static void main(String[] args) {
        int choice = -1;
        int h;
        while (choice != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles  triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Print the rectangle");
                    System.out.println("Enter height:");
                    h = sc.nextInt();
                    for(int i =0; i < h; i++){
                        System.out.println("* * * * * *");
                    }
                    break;
                case 2:
                    System.out.println("Print the square triangle");
                    System.out.println("Enter height:");
                    h = sc.nextInt();
                    System.out.println("Bottom - left");
                    for (int i = 1; i <= h; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    System.out.println("Top - Left");
                    for (int i = 1; i <= h; i++) {
                        for (int j = h - i; j >= 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    System.out.println("Bottom - Right");
                    for (int i = 1; i <= h; i++) {
                        for (int j = h - i; j > 0; j--) {
                            System.out.print("  ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }

                    System.out.println("Top - Right");
                    for (int i = 1; i <= h; i++) {
                        for (int k = 1; k < i; k++) {
                            System.out.print("  ");
                        }
                        for (int j = h - i; j >= 0; j--) {
                            System.out.print("* ");
                        }

                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Print isosceles  triangle");
                    System.out.println("Enter height:");
                    h = sc.nextInt();
                    for (int i = 1; i <= h; i++) {
                        for (int j = h - i; j > 0; j--) {
                            System.out.print(" ");
                        }
                        for (int k = 1; k <= i; k++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 4:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
