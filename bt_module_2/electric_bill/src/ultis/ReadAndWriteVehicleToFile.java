package ultis;

import models.Car;
import models.Motobike;
import models.Truck;
import models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteVehicleToFile {
    private static final String CAR_FILE = "src\\data\\car_file.csv";
    private static final String TRUCK_FILE = "src\\data\\truck_file.csv";
    private static final String MOTOBIKE_FILE = "src\\data\\motobike_file.csv";
    public static List<Vehicle> readFile(String filePath) {
        List<Vehicle> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReaderFile = new BufferedReader(fileReader);
            String line;
            String[] vehicle;
            while ((line = bufferedReaderFile.readLine()) != null) {
                vehicle = line.split(",");
                if (filePath.equals(TRUCK_FILE)) {
                    list.add(new Truck(vehicle[0], vehicle[1], vehicle[2], vehicle[3], Double.parseDouble(vehicle[4])));
                } else if (filePath.equals(CAR_FILE)) {
                    list.add(new Car(vehicle[0], vehicle[1], vehicle[2], vehicle[3], Integer.parseInt(vehicle[4]), vehicle[5]));
                } else {
                    list.add(new Motobike(vehicle[0], vehicle[1], vehicle[2], vehicle[3], Double.parseDouble(vehicle[4])));
                }
            }
            bufferedReaderFile.close();
        } catch (Exception e) {
            System.err.println("Movie File: File not found or failure document!");
        }
        return list;
    }

    public static void writeFile(List<Vehicle> vehicleList, String filePath) {
        try {
            File file = new File(filePath);
            file.delete();
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Vehicle movie : vehicleList) {
                bufferedWriter.write(movie.writeToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
