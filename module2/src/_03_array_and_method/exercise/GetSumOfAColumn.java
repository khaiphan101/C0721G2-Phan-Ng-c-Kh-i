package _03_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class GetSumOfAColumn {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.println("enter size of 2 demension array");
        int size = sc.nextInt();
        int[][] arr = new int[size][];
        for (int i = 0; i < arr.length; i++){
            arr[i] = inputArray(i);
        }

        for(int i = 0; i < arr.length; i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println("Enter the column that you want to sum:");
        int column = sc.nextInt();
        System.out.println("sum of column "+ column + " = " + getsum(arr, column));
    }
    static int getsum(int [][] arr, int col) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i][col];
        }
        return sum;
    }
    static int[] inputArray(int index){
        System.out.println("enter length of array[" + index +"]");
        int length = sc.nextInt();
        int[] array = new int [length];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array"+ index + ". Enter value of index " + i);
            array[i] = sc.nextInt();
        }
        return array;
    }
}
