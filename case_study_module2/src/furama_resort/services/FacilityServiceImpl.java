package furama_resort.services;

import furama_resort.models.Facility;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private final String FACILITYS_FILE = "src/furama_resort/data/list_of_facility.csv";
    LinkedHashMap<Facility, Integer> facilityList = readFile(FACILITYS_FILE);
    Scanner sc = new Scanner(System.in);

    @Override
    public void showList() {
        System.out.println("Facility's list:");
        Set<Facility> keySet = facilityList.keySet();
        for (Facility key : keySet) {
            System.out.println(key + " " + facilityList.get(key));
        }
    }

    @Override
    public void add() {
//        //code them moi
        int choice = -1;
        while (choice !=0){
        System.out.println("menu service:");
        System.out.println("1.\tVilla\n" +
                "2.\tHouse\n" +
                "3.\tRoom\n" +
                "0.\tExit\n");
        System.out.print("Your choice: ");
            choice= Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    Villa newVilla = new Villa("villa", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), intputRoomStandar(), inputFloors(), inputPoolArea());
                    facilityList.put(newVilla, 1);
                    this.writeFile(newVilla, FACILITYS_FILE);
                    break;
                case 2:
                    House newHouse = new House("House", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), intputRoomStandar(), inputFloors());
                    facilityList.put(newHouse, 1);
                    this.writeFile(newHouse, FACILITYS_FILE);
                    break;
                case 3:
                    Room newRoom = new Room("Room", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), inputFreeService());
                    facilityList.put(newRoom, 1);
                    this.writeFile(newRoom, FACILITYS_FILE);
                    break;
                case 0:
                    break;
            }
        }
    }

    public LinkedHashMap<Facility, Integer> readFile(String filePath) {
        LinkedHashMap<Facility, Integer> list = new LinkedHashMap();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] facility;
            while ((line = bufferedReaderFile.readLine()) != null) {
                facility = line.split(",");
//                private String serviceName;
//                private float area;
//                private float rentalCosts;
//                private int maxPeople;
//                private String rentalType
                if (facility[0].equals("Villa")) {
                    list.put(new Villa(facility[0], Float.parseFloat(facility[1]), Float.parseFloat(facility[2]), Integer.parseInt(facility[3]), facility[4], facility[5], Integer.parseInt(facility[6]), Float.parseFloat(facility[7])), 1);
                }
                else if(facility[0].equals("House")){
                    list.put(new House(facility[0], Float.parseFloat(facility[1]), Float.parseFloat(facility[2]), Integer.parseInt(facility[3]), facility[4], facility[5], Integer.parseInt(facility[6])) ,1);
                }
                else {
                    list.put(new Room(facility[0], Float.parseFloat(facility[1]), Float.parseFloat(facility[2]), Integer.parseInt(facility[3]), facility[4], facility[5]), 1);
                }
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(Facility facility, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(facility.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float inputArea() {
        System.out.println("Enter area: ");
        return Float.parseFloat(sc.nextLine());
    }

    public int inputMaxPeople() {
        System.out.println("Enter max people: ");
        return Integer.parseInt(sc.nextLine());
    }

    public float inputRentalCost() {
        System.out.println("Enter rental cost: ");
        return Float.parseFloat(sc.nextLine());
    }

    public String inputRentalType() {
        System.out.println("Enter rental type: ");
        return sc.nextLine();
    }

    public String intputRoomStandar() {
        System.out.println("Enter room standar: ");
        return sc.nextLine();
    }

    public int inputFloors() {
        System.out.println("Enter floors: ");
        return Integer.parseInt(sc.nextLine());
    }

    public float inputPoolArea() {
        System.out.println("Enter pool erea: ");
        return Float.parseFloat(sc.nextLine());
    }

    public String inputFreeService() {
        System.out.println("Enter free service: ");
        return sc.nextLine();
    }

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }
}
