package service;

import models.LimitShortTerm;
import models.LongTerm;
import models.Passbook;
import models.UnlimitShortTerm;
import ultis.*;


import java.util.List;
import java.util.Scanner;


public class PassBookServiceImpl implements PassBookService {
    private final String LONG_TERM_FILE = "src\\data\\long_term_file.csv";
    private final String SHORT_TERM_FILE = "src\\data\\short_term_file.csv";
    private final String CUSTOMER_FILE = "src\\data\\customer_file.csv";
    Scanner sc = new Scanner(System.in);
    List<Passbook> longTermList = ReadAndWritePassbookToFile.readFile(LONG_TERM_FILE);
    List<Passbook> shortTermList = ReadAndWritePassbookToFile.readFile(SHORT_TERM_FILE);


    public void add() {
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("************Thêm mới sổ tiết kiệm************\n" +
                    "1.\tThêm mới sổ tiết kiệm ngắn hạn\n" +
                    "2.\tThêm mới sổ tiết kiệm dài hạn\n" +
                    "3.\tThoát\n");
            System.out.print("xin mời nhập: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addShortTermBook();
                    break;
                case "2":
                    addLongTermBook();
                    break;
                case "3":
                    break;
                default:
                    System.err.println("Lỗi nhập liệu, xin mời nhập lại");
                    System.out.println();
            }
        }
    }

    public void showList() {
        String choice = "";
        while (!choice.equals("3")) {
            System.out.println("************Xem danh sách sổ tiết kiệm************\n" +
                    "1.\tXem danh sách sổ tiết kiệm ngắn hạn\n" +
                    "2.\tXem danh sách sổ tiết kiệm dài hạn\n" +
                    "3.\tThoát\n");
            System.out.print("Lựa chọn của bạn: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Danh sách sổ tiết kiệm ngắn hạn:");
                    for (Passbook passbook : shortTermList) {
                        System.out.println(passbook);
                    }
                    break;
                case "2":
                    System.out.println("Danh sách sổ tiết kiệm dài hạn:");
                    for (Passbook passbook : longTermList) {
                        System.out.println(passbook);
                    }
                    break;
                case "3":
                    break;
                default:
                    System.err.println("Lỗi nhập liệu, vui long nhập lại");
                    System.out.println();
            }
        }
    }

    public void addLongTermBook() {


        String idBook = Input.inputIdBook();
        String idCustomer = Input.getIdCustomer();
        String openDay = Input.inputopenDay();
        String depositDay = Input.inputdepositDay();
        String deposit = Input.inputdeposit();
        String interestRate = Input.inputinterestRate();
        String period = Input.inputperiod();
        String offers = Input.inputoffers();

        longTermList.add(new LongTerm(idBook, idCustomer, openDay, depositDay, deposit, interestRate, period, offers));
        ReadAndWritePassbookToFile.writeFile(longTermList, LONG_TERM_FILE);
    }

    public void addShortTermBook() {
        String choice = "";
        boolean flag = true;
        while (flag) {
            System.out.println("************Thêm mới sổ tiết kiệm ngắn hạn************\n" +
                    "1.\tSổ tiết kiêm vô thời hạn\n" +
                    "2.\tSổ tiết kiêm có thời hạn\n" +
                    "3.\tThoát");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addUnlimmitedShortTerm();
                    flag = false;
                    break;
                case "2":
                    addlimmitedShortTerm();
                    flag = false;
                    break;
                case "3":
                    flag = false;
                    break;
                default:
                    System.err.println("lỗi nhập liệu, mời nhập lại!");
            }
        }
    }

    public void addUnlimmitedShortTerm() {
        String idBook = Input.inputIdBook();
        String idCustomer = Input.getIdCustomer();
        String openDay = Input.inputopenDay();
        String depositDay = Input.inputdepositDay();
        String deposit = Input.inputdeposit();
        String interestRate = Input.inputinterestRate();
        shortTermList.add(new UnlimitShortTerm(idBook, idCustomer, openDay, depositDay, deposit, interestRate));
        ReadAndWritePassbookToFile.writeFile(shortTermList, SHORT_TERM_FILE);
    }

    public void addlimmitedShortTerm() {
        String idBook = Input.inputIdBook();
        String idCustomer = Input.getIdCustomer();
        String openDay = Input.inputopenDay();
        String depositDay = Input.inputdepositDay();
        String deposit = Input.inputdeposit();
        String interestRate = Input.inputinterestRate();
        String period = Input.inputperiod();
        shortTermList.add(new LimitShortTerm(idBook, idCustomer, openDay, depositDay, deposit, interestRate, period));
        ReadAndWritePassbookToFile.writeFile(shortTermList, SHORT_TERM_FILE);
    }

//    public void delete() {
//        System.out.println("enter show code you want to delete:");
//        try {
//            String info = sc.nextLine();
//            for (int i = 0; i < showList.size(); i++) {
//                if (info.equals(showList.get(i).getCodeShow())) {
//                    System.out.println("Confirm that you want to delete this show?\n" +
//                            "1.\tYes\n" +
//                            "2.\tNo\n" +
//                            "Please enter your choice: ");
//                    int choice = Integer.parseInt(sc.nextLine());
//                    if (choice == 1) {
//                        showList.remove(i);
//                        ReadAndWriteShowToFile.writeFile(showList);
//                        break;
//                    } else if (choice == 2) {
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
}
