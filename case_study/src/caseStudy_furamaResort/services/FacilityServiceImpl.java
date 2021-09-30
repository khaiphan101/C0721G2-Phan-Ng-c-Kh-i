package caseStudy_furamaResort.services;

import caseStudy_furamaResort.models.Employee;
import caseStudy_furamaResort.models.Facility;
import caseStudy_furamaResort.models.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements FacilityService {
    private final String FACILITYS_FILE = "src\\caseStudy_furamaResort\\data\\list_of_facility";
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

//        Facility facility = new Employee();
//
//        System.out.println("Enter employee code:");
//
//        this.writeFile(facility, FACILITYS_FILE);
//        facilityList.put(facility, 1);
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

}
