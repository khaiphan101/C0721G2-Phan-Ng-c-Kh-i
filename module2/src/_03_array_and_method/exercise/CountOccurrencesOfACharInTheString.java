package _03_array_and_method.exercise;

import java.util.Scanner;

public class CountOccurrencesOfACharInTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String:");

        String str = sc.nextLine();
        System.out.println("Enter a char");
        char c = sc.next().charAt(0);
        int count = 0;
//        c1:
//        chuyển chuỗi thành arr
//        //String[] arr = str.split(""); //nếu chuyển về chuỗi string thì so sánh với char ép kiểu string
//        char[] arr = str.toCharArray();
//
//        for(int i = 0; i < arr.length; i++){
//            if(c == arr[i]) {
//                count++;
//            }
//        }
//        System.out.println("Number of Occurrences of char " + c + " = " + count);
//        c2:
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }
        if(count == 0){
            System.out.println("char " + c +" is not appear in String");
        }
        else {
            System.out.println("Number of Occurrences of char " + c + " = " + count);
        }

    }
}
