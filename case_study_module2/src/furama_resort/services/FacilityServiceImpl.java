package furama_resort.services;

import furama_resort.models.Facility;
import furama_resort.models.House;
import furama_resort.models.Room;
import furama_resort.models.Villa;
import furama_resort.utils.WrongFormatException;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

import static furama_resort.utils.RegexFacility.*;

public class FacilityServiceImpl implements FacilityService {
    private final String VILLA_FILE = "src\\furama_resort\\data\\list_of_villa.csv";
    private final String HOUSE_FILE = "src\\furama_resort\\data\\list_of_house.csv";
    private final String ROOM_FILE = "src\\furama_resort\\data\\list_of_room.csv";

    LinkedHashMap<Facility, Integer> villaList = readFile(VILLA_FILE);
    LinkedHashMap<Facility, Integer> houseList = readFile(HOUSE_FILE);
    LinkedHashMap<Facility, Integer> roomList = readFile(ROOM_FILE);
    Scanner sc = new Scanner(System.in);

    @Override
    public void showList() {
        System.out.println("Villa's list:");
        Set<Facility> keySet = villaList.keySet();
        for (Facility key : keySet) {
            System.out.println(key + " " + villaList.get(key));
        }
        System.out.println("House's list:");
        Set<Facility> keySet1 = houseList.keySet();
        for (Facility key : keySet1) {
            System.out.println(key + " " + houseList.get(key));
        }
        System.out.println("Room's list:");
        Set<Facility> keySet2 = roomList.keySet();
        for (Facility key : keySet2) {
            System.out.println(key + " " + roomList.get(key));
        }
    }

    @Override
    public void add() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("menu service:");
            System.out.println("1.\tVilla\n" +
                    "2.\tHouse\n" +
                    "3.\tRoom\n" +
                    "0.\tExit\n");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    Villa newVilla = new Villa(inputIdFacility(),inputServiceName(), inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), 0, intputRoomStandar(), inputFloors(), inputPoolArea());
                    villaList.put(newVilla, newVilla.getValue());
                    this.writeFile(newVilla, VILLA_FILE);
                    break;
                case 2:
                    House newHouse = new House(inputIdFacility(),inputServiceName(), inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), 0, intputRoomStandar(), inputFloors());
                    houseList.put(newHouse, newHouse.getValue());
                    this.writeFile(newHouse, HOUSE_FILE);
                    break;
                case 3:
                    Room newRoom = new Room(inputIdFacility(),inputServiceName(), inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), 0, inputFreeService());
                    roomList.put(newRoom, newRoom.getValue());
                    this.writeFile(newRoom, ROOM_FILE);
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
                if (filePath.equals(VILLA_FILE)) {
                    list.put(new Villa(facility[0],facility[1], Float.parseFloat(facility[2]), Float.parseFloat(facility[3]), Integer.parseInt(facility[4]), facility[5],Integer.parseInt(facility[6]), facility[7], Integer.parseInt(facility[8]), Float.parseFloat(facility[9])), Integer.parseInt(facility[6]));
                } else if (filePath.equals(HOUSE_FILE)) {
                    list.put(new House(facility[0], facility[1], Float.parseFloat(facility[2]), Float.parseFloat(facility[3]), Integer.parseInt(facility[4]), facility[5], Integer.parseInt(facility[6]), facility[7], Integer.parseInt(facility[8])), Integer.parseInt(facility[6]));
                } else {
                    list.put(new Room(facility[0], facility[1], Float.parseFloat(facility[2]), Float.parseFloat(facility[3]), Integer.parseInt(facility[4]), facility[5], Integer.parseInt(facility[6]), facility[7]), Integer.parseInt(facility[6]));
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

    public String inputServiceName() {
        boolean flag;
        String serviceName = "";
        do {
            try {
                flag = true;
                System.out.println("Enter service name (EX: Villa 1,Room 2...): ");
                serviceName = sc.nextLine();
                checkName(serviceName);
            } catch (NumberFormatException | WrongFormatException e) {
                System.err.println(e.getMessage());
                flag = false;
            }
        } while (!flag);
        return serviceName;
    }
    public float inputArea() {
        boolean flag;
        float area = 0;
        do {
            try {
                flag = true;
                System.out.println("Enter area(should be more than 30 m2): ");
                area = Float.parseFloat(sc.nextLine());
                checkArea(area);
            } catch (NumberFormatException | WrongFormatException e) {
                flag = false;
            }
        } while (!flag);
        return area;
    }

    public int inputMaxPeople() {
        int people = 0;
        boolean flag;
        do {
            try {
                flag = true;
                System.out.println("Enter max people(should be between 0 and 20 people): ");
                people = Integer.parseInt(sc.nextLine());
                checkNumberOfPeople(people);
            } catch (NumberFormatException | WrongFormatException e) {
                flag = false;
            }
        } while (!flag);
        return people;
    }

    public float inputRentalCost() {
        boolean flag;
        float rentalCost = 0;
        do {
            try {
                flag = true;
                System.out.println("Enter rental cost(should be a positive number): ");
                rentalCost = Float.parseFloat(sc.nextLine());
                checkRentalCost(rentalCost);
            } catch (NumberFormatException | WrongFormatException e) {
                flag = false;
            }
        } while (!flag);
        return rentalCost;
    }

    public String inputRentalType() {
        boolean flag;
        String rentaltype = "";
        do {
            try {
                flag = true;
                System.out.println("Enter rental type(should be upper case at head's char): ");
                rentaltype = sc.nextLine();
                checkName(rentaltype);
            } catch (NumberFormatException | WrongFormatException e) {
                System.err.println(e.getMessage());
                flag = false;
            }
        } while (!flag);

        return rentaltype;
    }

    public String intputRoomStandar() {
        System.out.println("Enter room standar(should be upper case at head's char): ");
        return sc.nextLine();
    }

    public int inputFloors() {
        int floor = 0;
        boolean flag;
        do {
            try {
                flag = true;
                System.out.println("Enter floors: ");
                floor = Integer.parseInt(sc.nextLine());
                checkFloor(floor);
            } catch (NumberFormatException | WrongFormatException e) {
                flag = false;
            }
        } while (!flag);
        return floor;
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
    public void edit(int id) {

    }

    @Override
    public void delete() {

    }
    public void useFacility(String serviceName) {
        if (serviceName.contains("Villa")) {
            Set<Facility> keyVilla = villaList.keySet();
            for (Facility key : keyVilla) {
                if (key.getServiceName().contains(serviceName)) {
                    villaList.computeIfPresent(key, (k, v) -> v + 1);
                    break;
                }
            }
        } else if (serviceName.contains("House")) {
            Set<Facility> keyHouse = houseList.keySet();
            for (Facility key : keyHouse) {
                if (key.getServiceName().contains(serviceName)) {
                    houseList.computeIfPresent(key, (k, v) -> v + 1);
                    break;
                }
            }
        } else {
            Set<Facility> keyRoom = roomList.keySet();
            for (Facility key : keyRoom) {
                if (key.getServiceName().contains(serviceName)) {
                    roomList.computeIfPresent(key, (k, v) -> v + 1);
                    break;
                }
            }
        }
    }
    public void showMaintenanceList() {
        System.out.println("facility maintenance's list: ");
        System.out.println("Villa's list:");
        Set<Facility> keySet = villaList.keySet();
        for (Facility key : keySet) {
            if (villaList.get(key) >= 2) {
                System.out.println(key + " " + villaList.get(key));
            }
        }
        System.out.println("House's list:");
        Set<Facility> keySet1 = houseList.keySet();
        for (Facility key : keySet1) {
            if (houseList.get(key) >= 2) {
                System.out.println(key + " " + houseList.get(key));
            }
        }
        System.out.println("Room's list:");
        Set<Facility> keySet2 = roomList.keySet();
        for (Facility key : keySet2) {
            if (roomList.get(key) >= 2) {
                System.out.println(key + " " + roomList.get(key));
            }
        }
    }
    public String inputIdFacility(){
        boolean flag;
        String idFacility = "";
        do {
            try {
                flag = true;
                System.out.println("Enter id facility (Forat: SVXX-YYYY, ex: SVVL-1000): ");
                idFacility = sc.nextLine();
                checkFacility(idFacility);
            } catch (NumberFormatException | WrongFormatException e) {
                System.err.println(e.getMessage());
                flag = false;
            }
        } while (!flag);
        return idFacility;
    }
}
