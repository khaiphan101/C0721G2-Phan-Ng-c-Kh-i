package _01_introduction_to_java.practice;

import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a year");

        int year = Integer.parseInt(sc.nextLine());

        boolean isLeapYear = false;

        boolean isDivisibleBy4 = year % 4 == 0;
        if (isDivisibleBy4) {
            boolean isDivisibleBy100 = year % 100 == 0;
            if (isDivisibleBy100) {
                boolean isDivisibleBy400 = year % 400 == 0;
                if (isDivisibleBy400) {
                    isLeapYear = true;
                }
            } else
                isLeapYear = true;{
            }
        }

        if (isLeapYear) {
            System.out.printf(year + " is a leap year");
        } else {
            System.out.printf("%d is NOT a leap year", year);
        }
    }
}
