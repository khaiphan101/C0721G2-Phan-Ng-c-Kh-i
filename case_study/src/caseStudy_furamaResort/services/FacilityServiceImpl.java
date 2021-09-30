package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Customer;
import caseStudy_furamaResort.models.Facility;
import caseStudy_furamaResort.models.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService{
    LinkedHashMap<Facility, Integer> facilityList = new LinkedHashMap();
    Scanner sc = new Scanner(System.in);
    @Override
    public void showList() {
        System.out.println("Facility's list:");

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
                if(facility[0].equals("Villa")){
                    list.put(new Villa(facility[0], Float.parseFloat(facility[1]), Float.parseFloat(facility[2]), Integer.parseInt(facility[3]), facility[4], );
                }

            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
            e.printStackTrace();
        }
        return list;
    }

    public void writeFile(Customer customer, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(customer.writeToFile());
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
