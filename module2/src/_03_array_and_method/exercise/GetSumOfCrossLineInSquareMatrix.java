package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class GetSumOfCrossLineInSquareMatrix {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("enter size of square matrix");
        int size = sc.nextInt();
        int[][] arr = new int[size][];
        for (int i = 0; i < arr.length; i++){
            arr[i] = inputArray(i,size);
        }
//        int arr[][] = {{1,2,3}, {4,5,6},{7,8,9}};
        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("sum of cross line = " + getSumOfCrossLine(arr));
    }
    static int getSumOfCrossLine(int [][] arr) {
        // 1 đường chéo chính:
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(i == j) {
                    sum+= arr[i][j];
                }
            }
        }
        return sum;
        //sum 2 đường chéo chính:
//        int sum = 0;
//        for(int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                if(i == j|| i+j == arr.length) {
//                    sum+= arr[i][j];
//                }
//            }
//        }
//        return sum;
    }

    static int[] inputArray(int index,int length){
        int[] array = new int [length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array" + index + ". Enter value of index " + i);
            array[i] = sc.nextInt();
        }
        return array;
    }
}
