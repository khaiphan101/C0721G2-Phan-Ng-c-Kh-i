package _09_dsa_list.exercise.implement_method_of_array_list;

import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(3, 4);
        printList(myList);
        System.out.println("- remove index 2: " + myList.remove(2));
        printList(myList);
        System.out.println("- clone:");
        MyList<Integer> clone = myList.clone();
        printList(clone);
        System.out.println("- boolean check list contain 4: " + myList.contains(4));
        System.out.println("- index of 2: " + myList.indexOf(2));
        System.out.println("- clear: ");
        myList.clear();
        printList(myList);
    }
    public static void printList(MyList<Integer> myList){
        System.out.print("list = [ ");
        for (int i = 0; i < myList.size() && myList.get(i)!=null; i++) {
            System.out.print(myList.get(i) + " ");
        }
        System.out.println("]");
    }
}
