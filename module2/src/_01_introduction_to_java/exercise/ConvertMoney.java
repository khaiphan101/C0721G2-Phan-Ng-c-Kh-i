package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ConvertMoney {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input money(USD)");
        int amount = sc.nextInt();
        int result = amount * 23000;
        System.out.println(amount + " USD = " + result + " VND");
    }
}

