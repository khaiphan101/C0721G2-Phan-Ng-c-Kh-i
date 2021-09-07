package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxNumberOf2DemensionArray {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[][] arr = new int[2][];

        System.out.println("2 Demension array");
        arr[0] = inputArray("first");
        arr[1] = inputArray("second");
        System.out.println(Arrays.toString(arr[0]) + Arrays.toString(arr[1]));

        int max = arr[0][0];
        int iMax = 0;
        int jMax = 0;
        for (int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(max < arr[i][j]){
                    max = arr[i][j];
                    iMax = i;
                    jMax = j;
                }
            }
        }
        System.out.println("max: " + "arr[" + iMax + "]" + "[" + jMax + "] = " + max);
    }

    static int[] inputArray(String input){
        System.out.println("enter length of the " + input + " array");
        int length = sc.nextInt();
        int[] array = new int [length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array0. Enter value of index " + i);
            array[i] = sc.nextInt();
        }
        return array;
    }
}
