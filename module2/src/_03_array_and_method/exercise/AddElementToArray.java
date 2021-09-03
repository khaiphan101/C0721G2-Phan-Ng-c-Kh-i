package _03_array_and_method.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9, 0, 0, 0, 0};
        Scanner sc = new Scanner(System.in);
        System.out.println("innitial array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the number to add");
        int X = sc.nextInt();
        sc.nextLine();
        int index;
        do{
            System.out.println("Enter the position to add");
            index = sc.nextInt();
        if(index <= -1 || index >= arr.length-1){
            System.out.println("Cannot add this number to array");
        }}while (index <= -1 || index >= arr.length-1);
        int temp1 = arr[index];
        int temp2;
        for(int i = index + 1; i < arr.length-1; i++) {
            temp2 = arr[i];
            arr[i] = temp1;
            temp1 = temp2;

        }
        arr[index] = X;
        System.out.println("Final array: ");
        System.out.println(Arrays.toString(arr));
    }

}
