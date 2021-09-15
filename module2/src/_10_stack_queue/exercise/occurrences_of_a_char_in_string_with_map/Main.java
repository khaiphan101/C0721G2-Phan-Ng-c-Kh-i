package _10_stack_queue.exercise.occurrences_of_a_char_in_string_with_map;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String string = "Xin chAo, toi daNg hoc codegym";
        countOccrencesOfChars(string);
    }
    public  static void countOccrencesOfChars(String string){
        String[] arrayString = string.toLowerCase().replaceAll("\\W", "").split("");
        System.out.println("String: " + string);
        TreeMap<String, Integer> map = new TreeMap<>();
        int value;
        for (int i = 0; i < arrayString.length; i++) {
            if (map.containsKey(arrayString[i])) {
                value = map.get(arrayString[i]) + 1;
                map.put(arrayString[i], value);
            } else {
                map.put(arrayString[i], 1);
            }
        }
        System.out.println(map);
    }
}
