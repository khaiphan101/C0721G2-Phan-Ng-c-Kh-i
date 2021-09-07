package _03_array_and_method.exercise;


import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Initial Array:\n" + Arrays.toString(arr));
        System.out.println("Enter the number to add");
        int x = sc.nextInt();
        sc.nextLine();
        int index;
        do {
            System.out.println("Enter the position to add");
            index = sc.nextInt();
            if (index <= -1 || index >= arr.length - 1) {
                System.out.println("Cannot add this number to array");
            }
        } while (index <= -1 || index >= arr.length - 1);

        arr = addX(index, arr, x);

        System.out.println("\nArray with " + x + " added:\n" +
                Arrays.toString(arr));
    }
    public static int[] addX(int n, int arr[], int x) {
        int newarr[] = new int[arr.length + 1];
        for (int i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        for (int i = n + 1; i < newarr.length; i++) {
            newarr[i] = arr[i - 1];
        }
        return newarr;
    }

}
