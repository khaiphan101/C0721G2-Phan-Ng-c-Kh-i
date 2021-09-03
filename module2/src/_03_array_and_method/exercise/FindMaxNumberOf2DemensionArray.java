package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxNumberOf2DemensionArray {
    public static void main(String[] args) {

        int[][] arr = new int[2][];
        Scanner sc = new Scanner(System.in);
        System.out.println("2 Demension array");
        System.out.println("enter length of the first array");
        int length1 = sc.nextInt();
        arr[0] = new int [length1];
        for (int i = 0; i < arr[0].length; i++) {
            System.out.println("Array0. Enter value of index " + i);
            arr[0][i] = sc.nextInt();
        }
        System.out.println("enter length of the second array");
        int length2 = sc.nextInt();
        arr[1] = new int [length2];
        for (int i = 0; i < arr[1].length; i++) {
            System.out.println("Array1. Enter value of index " + i);
            arr[1][i] = sc.nextInt();
        }

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
}
