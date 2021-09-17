import netscape.security.UserTarget;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3, 6};

        System.out.println(almostIncreasingSequence(arr));
    }

    static boolean almostIncreasingSequence(int[] sequence) {
        List<Integer> list1 = new ArrayList<>();
        for (int a : sequence) {
            list1.add(a);
        }
        if(list1.size()==1) return false;
        for(int i = 0; i< list1.size()-1; i++){
            if(list1.get(i) >= list1.get(i+1)){
                list1.remove(i);
                i= i-2;
            }
        }
        if(list1.size()-1 == sequence.length){
            List<Integer> list2 = new ArrayList<>();
            for (int a : list1) {
                list2.add(a);
            }
            Collections.sort(list2);
            System.out.println(list1);
            if(list1.equals(list2)) return true;

        }
        else return false;
        return true;
    }
}
