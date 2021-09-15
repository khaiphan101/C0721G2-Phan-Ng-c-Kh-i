package _10_stack_queue.exercise.reverse_element_by_stack;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        System.out.println("innitial array: " + Arrays.toString(array));
        Stack<Integer> stack = new Stack<>();
        for(int element : array) {
            stack.push(element);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println("reveresed array: " + Arrays.toString(array));
    }


}
