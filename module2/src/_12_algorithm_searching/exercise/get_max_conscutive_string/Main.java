package _12_algorithm_searching.exercise.get_max_conscutive_string;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter a string:");
//        String string = sc.nextLine();
        String string = "abcabcdgabxy";
        System.out.println("string1: " + string);
        System.out.println(getMaxConscutiveString(string));
        string = "abcabcdgabmnsxy";
        System.out.println("string2: " + string);
        System.out.println(getMaxConscutiveString(string));
    }
    public static String getMaxConscutiveString(String string) {
        String maxConscutiveString = "";
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
            for (int j = i+1; j < string.length(); j++){
                if(string.charAt(j) > list.get(list.size()-1)){//nếu lớn hơn phần tử cuối cùng thì add
                    list.add(string.charAt(j));
                }
                else
                    break;//không thì break;
            }
            if(maxConscutiveString.length() < list.size()){//so sánh độ dài
                maxConscutiveString = "";
                for( char element: list){
                    maxConscutiveString += element;
                }
            }

            list.clear();
        }

        return maxConscutiveString;
    }
}
