package _10_stack_queue.exercise.test_array_palindrome_with_queue;

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        String string = "Able was I ere I saw elbA";
        String[] arrayString = string.split("");
        for (int i = 0; i < arrayString.length; i++) {
            stack.push(arrayString[i]);
            queue.add(arrayString[i]);
        }
        boolean checkPalindrome = false;
        while (!stack.isEmpty()) {
            if (stack.pop().equals(queue.poll())) {
                checkPalindrome = true;
            } else {
                break;
            }
        }
        System.out.println(string);
        System.out.println(checkPalindrome ? "this string is a Palindrome" : "this string is not a palindrome");

    }
}
