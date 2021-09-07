package _03_array_and_method.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementInArray {
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        Scanner sc = new Scanner(System.in);
        System.out.println("innitial array:");
        System.out.println(Arrays.toString(arr));
        System.out.println("Enter the number to remove");
        int x = sc.nextInt();
        int index = findElementInArray(arr, x);
        if(index == -1) {
            System.out.println("Cannot find this number in array");
        }
        else{
            System.out.println("Final array: ");
            int temp = arr[index];
            for(int i = index; i < arr.length - 1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length-1] = temp;
            System.out.println(Arrays.toString(arr));
        }
    }
    static int findElementInArray(int[] array, int x){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == x) {
                System.out.println("Position of " + x + " in array: " + (i + 1));
                return i;
            }
        }
        return -1;
    }
}
