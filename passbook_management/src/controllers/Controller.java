package controllers;

import service.PassBookService;
import service.PassBookServiceImpl;

import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PassBookService passBookService = new PassBookServiceImpl();
        while (true) {
            try {
                System.out.println("TRÌNH QUẢN LÝ SỔ TIẾT KIỆM\n" +
                        "Chọn chức năng theo số (để tiếp tục):\n" +
                        "1.\tThêm mới sổ tiết kiệm\n" +
                        "2.\tXóa sổ tiết kiệm\n" +
                        "3.\tXem danh sách sổ tiết kiệm\n" +
                        "4.\tExit\n");
                System.out.print("Your choice: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        passBookService.add();
                        break;
                    case "2":

                        break;
                    case "3":
                        passBookService.showList();
                        break;
                    case "4":
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Lỗi nhập liệu, vui lòng nhập một số(1,2,3,4)!");
                        System.out.println();
                }
            } catch (Exception e) {
                System.err.println("Lỗi nhập liệu, vui lòng nhập lại");
                System.out.println();
            }
        }
    }
}
