package _03_array_and_method.exercise;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Concat2Arrays {
    public static void main(String[] args) {
        int [] arr1 = {4, 12, 7, 8};
        int [] arr2 = {3, 6, 9, 0};
        int [] arr3 = new int [arr1.length + arr2.length];
        for(int i = 0; i < arr3.length; i++) {
            if(i<arr1.length){
                arr3[i] = arr1[i];
            }
            else {
                arr3[i] = arr2[i-arr1.length];
            }
        }

        System.out.print("array1: ");
        System.out.println(Arrays.toString(arr1));
        System.out.print("array2: ");
        System.out.println(Arrays.toString(arr2));
        System.out.print("array3: ");
        System.out.println(Arrays.toString(arr3));

    }

}
