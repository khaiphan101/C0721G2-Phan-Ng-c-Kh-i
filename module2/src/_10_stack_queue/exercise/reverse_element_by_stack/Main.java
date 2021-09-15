package _10_stack_queue.exercise.reverse_element_by_stack;

import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println("Initial stack: " + stack.toString());
        int size = stack.size();
        String string = "";
        for (int i = 0; i < size; i++) {
            string += stack.pop();
        }
        System.out.println("stack pop to String: "+string);
        String[] array =   (string.split(""));
        System.out.println("String convert to array String: " + Arrays.toString(array));
        for (int i = 0; i <size; i++) {
            stack.push(Integer.parseInt(array[i]));
        }
        System.out.println("push array String to stack:");
        System.out.println("reverse stack: " + stack.toString());

    }


}
