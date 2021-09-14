package _09_dsa_list.exercise.implement_method_of_linked_list;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList<Integer> ll = new MyLinkedList();
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(5, 5);
        System.out.println(ll.printList());
        System.out.println("- remove index 3: ");
        ll.remove(3);
        System.out.println(ll.printList());
        System.out.println("- check remove element 5: " + ll.remove((Integer) 5));
        System.out.println(ll.printList());
        System.out.println("- boolean check remove element 8: " + ll.remove((Integer) 8));
        System.out.println(ll.printList());
        System.out.println("- size: " + ll.size());
        System.out.println("- clone:");
        MyLinkedList<Integer> ll2 = ll.clone();
        System.out.println("copy of LinkedList" + ll2.printList());
        System.out.println("- boolean check LinkedList constain 2: " + ll.contains((Integer) 2));
        System.out.println("- Index of 3:" + ll.indexOf((Integer) 3));
        System.out.println("- get index 1: " + ll.get(1));
        System.out.println("- get first index: " + ll.getFirst());
        System.out.println("- get last index: " + ll.getLast());
        System.out.println("- clear:");
        ll.clear();
        System.out.println(ll.printList());
    }
}
