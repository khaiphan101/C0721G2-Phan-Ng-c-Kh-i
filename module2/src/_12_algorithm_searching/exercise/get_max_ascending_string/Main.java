package _12_algorithm_searching.exercise.get_max_ascending_string;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String string = sc.nextLine();
        System.out.println(getMaxAscendingString(string));
    }
    public static String getMaxAscendingString(String string) {
        String maxAscendingString = "";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
            for (int j = i; j < string.length(); j++){
                if(string.charAt(j) > list.get(list.size()-1)){
                    list.add(string.charAt(j));
                }
            }
            if(maxAscendingString.length() < list.size()){
                maxAscendingString = "";
                for( char element: list){
                    maxAscendingString += element;
                }
            }

            list.clear();
        }

        return maxAscendingString;
    }
}
