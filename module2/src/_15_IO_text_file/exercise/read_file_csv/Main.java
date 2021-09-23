package _15_IO_text_file.exercise.read_file_csv;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ReadFile readfile = new ReadFile();
        ArrayList<Country> countriesList = readfile.readFile("src/_15_IO_text_file/exercise/read_file_csv/list_of_countries");
        System.out.println("List of country get from file:");
        for (Country country : countriesList){
            System.out.println(country.toString());
        }
    }

}
