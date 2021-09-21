package _12_algorithm_searching.exercise.binary_search_algorithm_with_recursive;

public class Main {
    static int[] list = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};
    public static void main(String[] args) {
        int left = 0;
        int right = list.length - 1;
        int value = 7;
        System.out.println("value " + value + " at index " + binarySearch(list, left, right, value));
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (value > array[middle]) {
            left = middle + 1;
        } else {
            right = middle - 1;
        }
        return binarySearch(array, left, right, value);
    }

}
