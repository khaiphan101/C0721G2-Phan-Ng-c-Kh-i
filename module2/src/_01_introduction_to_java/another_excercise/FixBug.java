package _01_introduction_to_java.another_excercise;

public class FixBug {
//public class BugWeek1 {
    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 12, 9, 6};
        int minNumber = a[0];
        for (int i = 1; i < a.length; i++) {
            if (minNumber > a[i]) {
                minNumber = a[i];
            }
        }
        System.out.println("Min = " + minNumber);
    }
}
