package _01_introduction_to_java.practice;

import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Show the number of days in a month");
        System.out.println("Enter month: ");
        int month = Integer.parseInt(sc.nextLine());
        System.out.println("Enter year: ");
        int year = Integer.parseInt(sc.nextLine());
        int days;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                days = 31; break;
            case 2:
                boolean isLeapYear = false;
                if (year % 4 == 0) {
                    if (year % 100 == 0) {
                        if (year % 400 == 0) {
                            isLeapYear = true;
                        }
                    } else
                        isLeapYear = true;{
                    }
                }
                if (isLeapYear) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                days = 30; break;
            default:
                days = 0; break;
        }
        if(days == 0){
            System.out.println("Invalid input");
        }
        else{
            System.out.println("The month " + month + " has " + days + " days");
        }
    }
}
