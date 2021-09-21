package _13_sort_algorithm.exercise.insertion_sort_algorithm_by_step;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
//    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        System.out.println(Arrays.toString(list));
        System.out.println("\nBegin sort processing...");
        insertionSortByStep(list);
    }
    public static void insertionSortByStep(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                System.out.println("while(pos = " + pos + ">0 && x = " + x + " < " + array[pos-1] + ")");
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
                System.out.println(Arrays.toString(array));
            }
            array[pos] = x;
            System.out.println("insert " + x);
            System.out.println(Arrays.toString(array));
        }
    }
}
