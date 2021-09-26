package caseStudy_furamaResort.controllers;

import caseStudy_furamaResort.services.EmployeeServiceImpl;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);
    static EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

    public static void main(String[] args) {

        displayMainMenu();

    }

    public static void displayMainMenu() {
        while (true) {
            try {
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
                        boolean check = true;
                        int choice1 = 0;
                        while (choice1 != 4) {
                            try {
                                System.out.println("1.\tDisplay list employees\n" +
                                        "2.\tAdd new employee\n" +
                                        "3.\tEdit employee\n" +
                                        "4.\tReturn main menu\n");
                                System.out.print("Your choice: ");
                                choice1 = Integer.parseInt(sc.nextLine());
                                switch (choice1) {
                                    case 1:
                                        employeeServiceImpl.showList();
                                        break;
                                    case 2:
                                        employeeServiceImpl.add();
                                        break;
                                    case 3:
                                        try {
                                            System.out.print("Enter employee code you want to edit:");
                                            int code = Integer.parseInt(sc.nextLine());
                                            employeeServiceImpl.editEmployee(code);
                                        } catch (Exception e) {
                                            System.err.println("Invalid input, please enter ordinal number(1,2,3,4)");
                                            System.out.println();
                                        }
                                }
                            } catch (Exception e) {
                                System.err.println("Invalid input, please enter ordinal number(1,2,3,4)");
                                System.out.println();
                            }
                        }

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
                        break;
                    default:
                        System.err.println("Invalid input number!");
                        System.out.println();
                }
            } catch (Exception e) {
                System.err.println("Invalid input, please enter ordinal number(1,2,3,4)");
                System.out.println();
            }

        }
    }
}
