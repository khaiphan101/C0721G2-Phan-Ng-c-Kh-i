package ultis;

import models.Brand;
import models.Car;
import models.Truck;
import models.Vehicle;

import java.util.List;
import java.util.Scanner;

public class Input {
    private static final String TRUCK_REGEX = "\\d{2}C-\\d{3}.\\d{2}";
    private static final String CAR_TOURRING_REGEX = "\\d{2}A-\\d{3}.\\d{2}";
    private static final String CAR_COACH_REGEX = "\\d{2}B-\\d{3}.\\d{2}";
    private static final String MOTOBIKE_REGEX = "\\d{2}-[A-Z]([0-9]|[A-Z])-\\d{3}.\\d{2}";
    private static final String CAR_FILE = "src\\data\\car_file.csv";
    private static final String TRUCK_FILE = "src\\data\\truck_file.csv";
    private static final String MOTOBIKE_FILE = "src\\data\\motobike_file.csv";
    static List<Brand> brandList = ReadAndWriteBrandsToFile.readFile();
    static List<Vehicle> truckList = ReadAndWriteVehicleToFile.readFile(TRUCK_FILE);
    static List<Vehicle> carList = ReadAndWriteVehicleToFile.readFile(CAR_FILE);
    static List<Vehicle> motobikeList = ReadAndWriteVehicleToFile.readFile(MOTOBIKE_FILE);

    static Scanner sc = new Scanner(System.in);

    public static String inputBKSTruck() {
        boolean checkDuplicate;
        String bks;
        do {
            checkDuplicate = true;
            System.out.println("Enter BKS (XXC-XXX.XX):");
            bks = RegexData.regexStr(sc.nextLine(), TRUCK_REGEX);
            for (Vehicle truck : truckList) {
                if (bks.equals(truck.getBKS())) {
                    System.err.println(bks + " is duplicate, please input again!");
                    checkDuplicate = false;
                    break;
                }
            }
        } while (!checkDuplicate);
        return bks;
    }

//    public static String inputBKSCar() {
//
//        boolean checkDuplicate;
//        String bks = "";
//        do {
//            checkDuplicate = true;
//            String choice = "";
//            while (!choice.equals("0")) {
//                System.out.println("\t************choose car type************\n" +
//                        "1.\tTourring car\n" +
//                        "2.\tCoach\n" +
//                        "0.\tExit");
//                choice = sc.nextLine();
//                switch (choice) {
//                    case "1":
//                        System.out.println("Enter BKS (XXA-XXX.XX):");
//                        bks = RegexData.regexStr(sc.nextLine(), CAR_TOURRING_REGEX);
//                        break;
//                    case "2":
//                        System.out.println("Enter BKS (XXB-XXX.XX):");
//                        bks = RegexData.regexStr(sc.nextLine(), CAR_COACH_REGEX);
//                        break;
//                    case "0":
//                        break;
//                    default:
//                        System.err.println("invalid input!");
//                }
//            }
//            for (Vehicle car : carList) {
//                if (bks.equals(car.getBKS())) {
//                    System.err.println(bks + " is duplicate, please input again!");
//                    checkDuplicate = false;
//                    break;
//                }
//            }
//        } while (!checkDuplicate);
//        return bks;
//    }

    public static String inputBKSTourring() {
        boolean checkDuplicate;
        String bks;
        do {
            checkDuplicate = true;
            System.out.println("Enter BKS (XXA-XXX.XX):");
            bks = RegexData.regexStr(sc.nextLine(), CAR_TOURRING_REGEX);
            for (Vehicle car : carList) {
                if (bks.equals(car.getBKS())) {
                    System.err.println(bks + " is duplicate, please input again!");
                    checkDuplicate = false;
                    break;
                }
            }
        } while (!checkDuplicate);
        return bks;
    }

    public static String inputBKSCoach() {
        boolean checkDuplicate;
        String bks;
        do {
            checkDuplicate = true;
            System.out.println("Enter BKS (XXB-XXX.XX):");
            bks = RegexData.regexStr(sc.nextLine(), CAR_COACH_REGEX);
            for (Vehicle car : carList) {
                if (bks.equals(car.getBKS())) {
                    System.err.println(bks + " is duplicate, please input again!");
                    checkDuplicate = false;
                    break;
                }
            }
        } while (!checkDuplicate);
        return bks;
    }

    public static String inputBKSMotobike() {
        boolean checkDuplicate;
        String bks;
        do {
            checkDuplicate = true;
            System.out.println("Enter BKS (XXC-XXX.XX (X : 0÷9))");
            bks = RegexData.regexStr(sc.nextLine(), MOTOBIKE_REGEX);
            for (Vehicle bike : motobikeList) {
                if (bks.equals(bike.getBKS())) {
                    System.err.println(bks + " is duplicate, please input again!");
                    checkDuplicate = false;
                    break;
                }
            }
        } while (!checkDuplicate);
        return bks;
    }

    public static String getBrandName() {
        System.out.println("brand list:");
        for (int i = 0; i < brandList.size(); i++) {
            System.out.println(i + 1 + ". " + brandList.get(i));
        }
        int choice;
        while (true) {
            try {
                System.out.println("choose brand(1,2,3...):");
                choice = Integer.parseInt(sc.nextLine());
                return brandList.get(choice - 1).getBrandName();
            } catch (Exception e) {
                System.err.println("fail input movie, please input again!");
            }
        }
    }

    public static String inputYearOfManufactor() {
        System.out.println("input year of menufactor:");
        return (sc.nextLine());
    }

    public static String inputOwner() {
        System.out.println("input owner");
        return (sc.nextLine());
    }

    public static Double inputWeight() {
        System.out.println("input weight");
        return (Double.parseDouble(sc.nextLine()));
    }

    public static int inputseatsNumber() {
        System.out.println("input number of seats");
        return Integer.parseInt(sc.nextLine());
    }

    public static Double inputCapacity() {
        System.out.println("input capacity");
        return Double.parseDouble(sc.nextLine());
    }
}
