package caseStudy_furamaResort.controllers;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        displayMainMenu();
    }
    public static void displayMainMenu(){
        while(true) {
            System.out.println("1.\tEmployee Management\n" +
                    "2.\tCustomer Management\n" +
                    "3.\tFacility Management \n" +
                    "4.\tBooking Management\n" +
                    "5.\tPromotion Management\n" +
                    "6.\tExit\n");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1\tDisplay list employees\n" +
                            "2\tAdd new employee\n" +
                            "3\tEdit employee\n" +
                            "4\tReturn main menu\n");
                    System.out.print("Your choice: ");
                    int choice1 = Integer.parseInt(sc.nextLine());
                case 2:
                    System.out.println("1.\tDisplay list customers\n" +
                            "2.\tAdd new customer\n" +
                            "3.\tEdit customer\n" +
                            "4.\tReturn main menu\n");
                    System.out.print("Your choice: ");
                    int choice2 = Integer.parseInt(sc.nextLine());
                case 3:
                    System.out.println("1\tDisplay list facility\n" +
                            "2\tAdd new facility\n" +
                            "3\tDisplay list facility maintenance\n" +
                            "4\tReturn main menu\n");
                    System.out.print("Your choice: ");
                    int choice3 = Integer.parseInt(sc.nextLine());
                case 4:
                    System.out.println("1.\tAdd new booking\n" +
                            "2.\tDisplay list booking\n" +
                            "3.\tCreate new constracts\n" +
                            "4.\tDisplay list contracts\n" +
                            "5.\tEdit contracts\n" +
                            "6.\tReturn main menu\n");
                    System.out.print("Your choice: ");
                    int choice4 = Integer.parseInt(sc.nextLine());
                case 5:
                    System.out.println("1.\tDisplay list customers use service\n" +
                            "2.\tDisplay list customers get voucher\n" +
                            "3.\tReturn main menu\n");
                    System.out.print("Your choice: ");
                    int choice5 = Integer.parseInt(sc.nextLine());
                case 6:
                    System.exit(0);
            }
        }
    }
}
