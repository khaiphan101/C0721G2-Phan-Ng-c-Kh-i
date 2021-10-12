package controller;

import services.VehicleService;
import services.VehicleServiceImpl;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleService vehicleService = new VehicleServiceImpl();
        while (true) {
            try {
                System.out.println("************Chọn chức năng************\n" +
                        "1.\tThêm mới phương tiện\n" +
                        "2.\tHiển thị phương tiện\n" +
                        "3.\tXóa phương tiện\n" +
                        "4.\tThoát\n");
                System.out.print("Lựa chọn của bạn: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        vehicleService.add();
                        break;
                    case "2":
                        vehicleService.showList();
                        break;
                    case "3":
                        vehicleService.deleteVehicle();
                        break;
                    case "4":
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
