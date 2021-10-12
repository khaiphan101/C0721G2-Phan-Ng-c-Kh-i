package ultis;

import models.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadCustomerFile {
    private static final String CUSTOMER_FILE = "src\\data\\customer_file.csv";

    public static List<Customer> readFile() {
        List<Customer> list = new ArrayList<>();
        try {
            File file = new File(CUSTOMER_FILE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line = "";
            String[] customer;
            while ((line = bufferedReaderFile.readLine()) != null) {
                customer = line.split(",");
                list.add(new Customer(customer[0],customer[1],customer[2],customer[3],customer[4]));
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("File not found or failure document!");
        }
        return list;
    }
}
