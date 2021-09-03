package _03_array_and_method.practice;
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray {
    public static void main(String[] args) {
        int size;
        int[] arr;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Enter a size: ");
            size = sc.nextInt();
            if(size > 20)
                System.out.println("size does not exceed 20");
        }while (size > 20);
        arr = new int[size];
        int  i = 0;
        while(i < arr.length) {
            System.out.println("enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
            i++;
        }
        System.out.println("initial array:");
        System.out.println(Arrays.toString(arr));
        for(int j = 0; j < arr.length/2;j++){
            int temp = arr[j];
            arr[j] = arr[size-1-j];
            arr[size-1-j] = temp;
        }
        System.out.println("reversed array:");
        System.out.println(Arrays.toString(arr));
    }
}
