package controller;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        ShowManagement showManagement = new ShowManagement();
        while (true) {
            try {
                System.out.println("1.\tXem toàn bộ suất chiếu\n" +
                        "2.\tThêm mới suất chiếu\n" +
                        "3.\tXóa suất chiếu\n" +
                        "4.\tExit\n");
                System.out.print("Your choice: ");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("All show:");

                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Invalid input number, please input again");
                        System.out.println();
                }
            } catch (Exception e) {
                System.err.println("Invalid input, please enter ordinal number(1,2,3,4)");
                System.out.println();
            }
        }
    }
}
