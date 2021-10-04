package furama_resort.services;

import furama_resort.models.*;

import java.io.*;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    Scanner sc = new Scanner(System.in);
    private String BOOKING_FILE = "src/furama_resort/data/list_of_booking.csv";
    TreeSet<Booking> bookingsList = this.readFile(BOOKING_FILE);

    @Override
    public void showList() {
        System.out.println("bookings's list:");
        for (Booking booking : bookingsList) {
            System.out.println(booking);
        }
    }

    public void add() {
////        //code them moi
//        int choice = -1;
//        while (choice !=0){
//            System.out.println("menu service:");
//            System.out.println("1.\tVilla\n" +
//                    "2.\tHouse\n" +
//                    "3.\tRoom\n" +
//                    "0.\tExit\n");
//            System.out.print("Your choice: ");
//            choice= Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    Villa newVilla = new Villa("villa", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), intputRoomStandar(), inputFloors(), inputPoolArea());
//                    facilityList.put(newVilla, 1);
//                    this.writeFile(newVilla, FACILITYS_FILE);
//                    break;
//                case 2:
//                    House newHouse = new House("House", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), intputRoomStandar(), inputFloors());
//                    facilityList.put(newHouse, 1);
//                    this.writeFile(newHouse, FACILITYS_FILE);
//                    break;
//                case 3:
//                    Room newRoom = new Room("Room", inputArea(), inputRentalCost(), inputMaxPeople(), inputRentalType(), inputFreeService());
//                    facilityList.put(newRoom, 1);
//                    this.writeFile(newRoom, FACILITYS_FILE);
//                    break;
//                case 0:
//                    break;
//            }
    }
    public TreeSet<Booking> readFile(String filePath) {
        TreeSet<Booking> list = new TreeSet<>(new BookingComparator());
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] booking;
            while ((line = bufferedReaderFile.readLine()) != null) {
                booking = line.split(",");
                list.add(new Booking(Integer.parseInt(booking[0]), booking[1], booking[2], booking[3], booking[4], booking[5]));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(Booking booking, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(booking.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
