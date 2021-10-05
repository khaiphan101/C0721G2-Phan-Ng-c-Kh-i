package furama_resort.services;

import furama_resort.models.*;
import furama_resort.utils.BookingComparator;

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

    @Override
    public void edit() {

    }

    @Override
    public void delete() {

    }

    //      private int code;
//    private String startDay;
//    private String endDay;
//    private int customerCode;
//    private String serviceName;
//    private String serviceType;
    public void add() {
        Booking booking = new Booking();
        System.out.println("Enter booking code:");
        booking.setCode(Integer.parseInt(sc.nextLine()));

        System.out.println("Enter start day:");
        booking.setStartDay(sc.nextLine());

        System.out.println("Enter end day:");
        booking.setEndDay(sc.nextLine());

        booking.setCustomerCode(inputCustomerCode());

        booking.setServiceName(inputServiceName());


        System.out.println("Enter service type:");
        booking.setServiceType(sc.nextLine());
        bookingsList.add(booking);
        writeFile(booking, BOOKING_FILE);
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
                list.add(new Booking(Integer.parseInt(booking[0]), booking[1], booking[2], Integer.parseInt(booking[3]), booking[4], booking[5]));
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

    public int inputCustomerCode() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        System.out.println("choose customer (by code): ");
        customerService.showList();
        System.out.println("your choice:");
        int customerCode = Integer.parseInt(sc.nextLine());
        for (Customer customer : customerService.customerList) {
            if (customerCode == customer.getCode()) {
                return customerCode;
            }
        }
        return 0;
    }

    public String inputServiceName() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        System.out.println("choose service name: ");
        facilityService.showList();
        System.out.println("your choice:");
        String name = sc.nextLine();
        for (Facility facility : facilityService.facilityList.keySet()) {
            if (name.equals(facility.getServiceName())) {
                return name;
            }
        }
        return "";
    }

}
