package furama_resort.controllers;

import furama_resort.services.*;

import java.util.Scanner;

public class FuramaController {
    static Scanner sc = new Scanner(System.in);
    static EmployeeService employeeService = new EmployeeServiceImpl();
    static CustomerService customerService = new CustomerServiceImpl();
    static FacilityService facilityService = new FacilityServiceImpl();
    static BookingService bookingService = new BookingServiceImpl();
    static ContractService contractService = new ContractServiceImpl();

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
                        manageEmployee();
                        break;
                    case 2:
                        manageCustomer();
                        break;
                    case 3:
                        manageFacility();
                        break;
                    case 4:
                        manageBooking();
                        break;
                    case 5:
                        System.out.println("1.\tDisplay list customers use service\n" +
                                "2.\tDisplay list customers get voucher\n" +
                                "3.\tReturn main menu\n");
                        System.out.print("Your choice: ");
                        int choice5 = Integer.parseInt(sc.nextLine());
                        break;
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

    public static void manageEmployee() {
        int choice = 0;
        while (choice != 4) {
            try {
                System.out.println("1.\tDisplay list employees\n" +
                        "2.\tAdd new employee\n" +
                        "3.\tEdit employee\n" +
                        "4.\tReturn main menu\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        employeeService.showList();
                        break;
                    case 2:
                        employeeService.add();
                        break;
                    case 3:
                        try {
                            System.out.print("Enter customer code you want to edit:");
                            int code = Integer.parseInt(sc.nextLine());
                            employeeService.edit(code);
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
    }

    public static void manageCustomer() {
        int choice = 0;
        while (choice != 4) {
            try {
                System.out.println("1.\tDisplay list customers\n" +
                        "2.\tAdd new customer\n" +
                        "3.\tEdit customer\n" +
                        "4.\tReturn main menu\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        customerService.showList();
                        break;
                    case 2:
                        customerService.add();
                        break;
                    case 3:
                        try {
                            System.out.print("Enter customer code you want to edit:");
                            int code = Integer.parseInt(sc.nextLine());
                            customerService.edit(code);
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
    }

    public static void manageFacility() {
        int choice = 0;
        while (choice != 4) {
            try {
                System.out.println("1.\tDisplay list facility\n" +
                        "2.\tAdd new facility\n" +
                        "3.\tDisplay list facility maintenance\n" +
                        "4.\tReturn main menu\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        facilityService.showList();
                        break;
                    case 2:
                        facilityService.add();
                        break;
                    case 3:
                        try {
                            System.out.print("Enter customer code you want to edit:");
                            int code = Integer.parseInt(sc.nextLine());
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
    }

    public static void manageBooking() {
        int choice = 0;
        while (choice != 6) {
            try {
                System.out.println("1.\tAdd new booking\n" +
                        "2.\tDisplay list booking\n" +
                        "3.\tCreate new constracts\n" +
                        "4.\tDisplay list contracts\n" +
                        "5.\tEdit contracts\n" +
                        "6.\tReturn main menu\n");
                System.out.print("Your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        bookingService.add();
                        break;
                    case 2:
                        bookingService.showList();
                        break;
                    case 3:
                        contractService.add();
                        break;
                    case 4:
                        contractService.showList();
                        break;
                    case 5:
                        contractService.showList();
                        try {
                            System.out.print("Enter id contract you want to edit:");
                            int idContract = Integer.parseInt(sc.nextLine());
                            contractService.edit(idContract);
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
    }
}
