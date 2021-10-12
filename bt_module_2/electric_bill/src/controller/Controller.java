package controller;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        VehicleService vehicleService = new VehicleServiceImpl();
        while (true) {
            try {
                System.out.println("CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n" +
                        "Chọn chức năng:\n"+
                        "1.\tThêm mới khách hàng\n" +
                        "2.\tHiển thị thông tin khách hàng\n" +
                        "3.\tTìm kiếm khách hàng\n" +
                        "4.\tThêm mới hóa đơn\n" +
                        "5.\tChỉnh sửa hóa đơn\n" +
                        "6.\tHiển thị thông tin chi tiết hóa đơn\n" +
                        "7.\tThoát\n");
                System.out.print("Lựa chọn của bạn: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":

                        break;
                    case "2":

                        break;
                    case "3":

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
