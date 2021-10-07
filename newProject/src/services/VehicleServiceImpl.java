package services;

import models.*;
import ultis.*;


import java.util.List;
import java.util.Scanner;


public class VehicleServiceImpl implements VehicleService{
    private final String CAR_FILE = "src\\data\\car_file.csv";
    private final String TRUCK_FILE = "src\\data\\truck_file.csv";
    private final String MOTOBIKE_FILE = "src\\data\\motobike_file.csv";
    Scanner sc = new Scanner(System.in);
    List<Vehicle> truckList = ReadAndWriteVehicleToFile.readFile(TRUCK_FILE);
    List<Vehicle> carList = ReadAndWriteVehicleToFile.readFile(CAR_FILE);
    List<Vehicle> motobikeList = ReadAndWriteVehicleToFile.readFile(MOTOBIKE_FILE);


    public void add() {
        String choice = "";
        while (!choice.equals("4")) {
            System.out.println("************Add new vehilce************\n" +
                    "1.\tAdd new truck\n" +
                    "2.\tAdd new car\n" +
                    "3.\tAdd new motobike\n" +
                    "4.\tExit\n");
            System.out.print("Your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addTruck();
                    break;
                case "2":
                    addCar();
                    break;
                case "3":
                    addMotobike();
                    break;

                case "4":
                    break;
                default:
                    System.err.println("Invalid input number, please input again");
                    System.out.println();
            }
        }
    }

    public void showList() {
        String choice = "";
        while (!choice.equals("4")) {
            System.out.println("************Show vehicle************\n" +
                    "1.\tshow trucks list\n" +
                    "2.\tshow cars list\n" +
                    "3.\tshow motobikes list\n" +
                    "4.\tExit\n");
            System.out.print("Your choice: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Truck's list:");
                    for (Vehicle truck : truckList) {
                        System.out.println(truck);
                    }
                    break;
                case "2":
                    System.out.println("Car's list:");
                    for (Vehicle car : carList) {
                        System.out.println(car);
                    }
                    break;
                case "3":
                    System.out.println("Motobike's list:");
                    for (Vehicle motobike : motobikeList) {
                        System.out.println(motobike);
                    }
                    break;
                case "4":
                    break;
                default:
                    System.err.println("Invalid input number, please input again");
                    System.out.println();
            }
        }
    }

    public void addTruck() {
        String bks = Input.inputBKSTruck();
        String brandName = Input.getBrandName();
        String yearOfManufactor = Input.inputYearOfManufactor();
        String owner = Input.inputOwner();
        Double weight = Input.inputWeight();
        truckList.add(new Truck(bks, brandName, yearOfManufactor, owner, weight));
        ReadAndWriteVehicleToFile.writeFile(truckList, TRUCK_FILE);
    }

    public void addCar() {
        String carType = "";
        String bks = "";
        String choice = "";
        boolean flag = true;
        while (flag) {
            System.out.println("************choose car type************\n" +
                    "1.\tTourring car\n" +
                    "2.\tCoach\n" +
                    "0.\tExit");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    carType = "tourring";
                    bks = Input.inputBKSTourring();
                    flag = false;
                    break;
                case "2":
                    carType = "coach";
                    bks = Input.inputBKSCoach();
                    flag = false;
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.err.println("invalid input!");
            }
        }
        String brandName = Input.getBrandName();
        String yearOfManufactor = Input.inputYearOfManufactor();
        String owner = Input.inputOwner();
        int seatsNumber = Input.inputseatsNumber();
        carList.add(new Car(bks, brandName, yearOfManufactor, owner, seatsNumber, carType));
        ReadAndWriteVehicleToFile.writeFile(carList, CAR_FILE);
    }

    public void addMotobike() {
        String bks = Input.inputBKSMotobike();
        String brandName = Input.getBrandName();
        String yearOfManufactor = Input.inputYearOfManufactor();
        String owner = Input.inputOwner();
        Double capacity = Input.inputCapacity();
        motobikeList.add(new Motobike(bks, brandName, yearOfManufactor, owner, capacity));
        ReadAndWriteVehicleToFile.writeFile(motobikeList, MOTOBIKE_FILE);
    }
    public void deleteVehicle(){
        while (true){
            System.out.println("enter bks you want to delete:");
            try {
                String info = sc.nextLine();
                checkValidateBKS(info);
                break;
            } catch (NotFoundVehicelException e) {
                e.getMessage("BKS does not exist");
            }
        }
    }
    public void checkValidateBKS(String info) throws NotFoundVehicelException{
        if(checkAndDeleteVehicle(info,truckList,TRUCK_FILE)||
        checkAndDeleteVehicle(info,carList,CAR_FILE)||
        checkAndDeleteVehicle(info,motobikeList,MOTOBIKE_FILE)){
        }else{
            throw new NotFoundVehicelException();
        }
    }
    public boolean checkAndDeleteVehicle(String info,List<Vehicle> list, final String FILE){
        for (Vehicle vehicle: list) {
            if (info.equals(vehicle.getBKS())) {
                System.out.println(vehicle);
                while(true){
                    System.out.println("Confirm that you want to delete this vehicle(Y/N)?");
                    String choice = sc.nextLine();
                    if (choice.equals("Y")) {
                        list.remove(vehicle);
                        ReadAndWriteVehicleToFile.writeFile(list,FILE);
                        System.out.println("comlete delete vehicle (press Enter to return to main menu)");
                        return true;
                    } else if (choice.equals("N")) {
                        return false;
                    }
                    else{
                        System.err.println("invalid input!");
                    }
                }

            }
        }
        return false;
    }
}
