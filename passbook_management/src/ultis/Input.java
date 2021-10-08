package ultis;


import models.Customer;
import models.Passbook;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String ID_BOOk = "STK-\\d{4}";

    private static final String LONG_TERM_FILE = "src\\data\\long_term_file.csv";
    private static final String SHORT_TERM_FILE = "src\\data\\short_term_file.csv";
    private static final String CUSTOMER_FILE = "src\\data\\customer_file.csv";

    static List<Passbook> longTermList = ReadAndWritePassbookToFile.readFile(LONG_TERM_FILE);
    static List<Passbook> shortTermList = ReadAndWritePassbookToFile.readFile(SHORT_TERM_FILE);
    static List<Customer> customerList = ReadCustomerFile.readFile();

    static Scanner sc = new Scanner(System.in);

    public static String inputIdBook() {
        System.out.println("Nhập mã số sổ:");
        return RegexData.regexStr(sc.nextLine(), ID_BOOk);
    }

    public static String getIdCustomer() {System.out.println("brand list:");
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println(i + 1 + ". " + customerList.get(i));
        }
        int choice;
        while (true) {
            try {
                System.out.println("Chọn mã khách hàng");
                choice = Integer.parseInt(sc.nextLine());
                return customerList.get(choice - 1).getIdcustomer();
            } catch (Exception e) {
                System.err.println("Lỗi nhập liệu!");
            }
        }
    }

    public static String inputopenDay() {
        System.out.println("Nhập ngày mở sổ");
        return (sc.nextLine());
    }

    public static String inputdepositDay() {
        System.out.println("Nhập ngày bắt đầu gửi");
        return (sc.nextLine());
    }
    public static String inputdeposit() {
        System.out.println("Nhập số tiền gửi");
        return (sc.nextLine());
    }
    public static String inputinterestRate() {
        System.out.println("Nhập lãi suất ngân hàng");
        return (sc.nextLine());
    }
    public static String inputperiod() {
        System.out.println("Nhập kỳ hạn");
        return (sc.nextLine());
    }
    public static String inputoffers() {
        System.out.println("Nhập ưu đãi");
        return (sc.nextLine());
    }


}
