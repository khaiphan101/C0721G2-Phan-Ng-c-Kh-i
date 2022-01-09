import java.util.ArrayList;
import java.util.List;

public class a {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 0, 0, 3, 2, 1, 3, 0, 3};
        maxRepeatingElementInPlace(a);
        char[] c = new char[]
    }


    public static void maxRepeatingElementInPlace(int[] a) {
        int size = a.length;
        int maxNumber = 0;
        for (int i =0; i< size-1; i++){
            int temp = 1;
            for (int j = i+1; j < size-1; j++){
                if (a[i] == a[j]){
                    temp++;
                }
            }
            if(temp>maxNumber){
                maxNumber == temp;
            }
        }
    }
}