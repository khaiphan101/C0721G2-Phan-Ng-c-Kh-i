package _13_sort_algorithm.exercise.insertion_sort_algorithm;

import java.util.Arrays;

public class Main {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void main(String[] args) {
        System.out.println("Your input list: ");
        System.out.println(Arrays.toString(list));
        insertionSort(list);
        System.out.println("final list:");
        System.out.println(Arrays.toString(list));
    }
    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }
}
