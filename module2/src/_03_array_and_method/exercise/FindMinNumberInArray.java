package _03_array_and_method.exercise;

import java.util.Scanner;

public class FindMinNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter length of the first array");
        int size = sc.nextInt();
        int[] arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter value of index " + i);
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        for (int i = 1; i < size; i++){
            if (min>arr[i]) {
                    min = arr[i];
            }
        }
        System.out.println("min= " + min);
    }
}
