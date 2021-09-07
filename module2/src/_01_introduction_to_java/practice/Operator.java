package _01_introduction_to_java.practice;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều dài hình chữ nhật");
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập chiều rộng hình chữ nhật");
        int b = Integer.parseInt(sc.nextLine());
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("S = a * b = " + (a*b));
    }
}
