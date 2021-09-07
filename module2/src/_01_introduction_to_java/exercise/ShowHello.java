package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ShowHello {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Hello " + name);
    }
}
