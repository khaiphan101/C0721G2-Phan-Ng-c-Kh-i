package _12_algorithm_searching.practic.algorithm_complexity_test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();
//        String inputString = "nan";
        int[] frequentChar = new int[255];                         //{1}
        for (int i = 0; i < inputString.length(); i++) {           //{2}
            /* Tìm ví trí tương ứng của ký tự trong bảng ASCII */
            int ascii = (int) inputString.charAt(i);               //{3}
            System.out.println("charAt(" + i + ") = " + inputString.charAt(i));
            System.out.println("ascii = " + ascii);
            /* Tăng giá trị tần suất */
            System.out.println(Arrays.toString(frequentChar));
            frequentChar[ascii] += 1;                              //{4}
            System.out.println(Arrays.toString(frequentChar));
        }
        int max = 0;                                             //{5}
        char character = (char) 255; /* empty character */      //{6}
        for (int j = 0; j < 255; j++) {                         //{7}
            if (frequentChar[j] > max) {                        //{8}
                max = frequentChar[j];                          //{9}
                character = (char) j;                           //{10}
            }
        }
        System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
    }
}
