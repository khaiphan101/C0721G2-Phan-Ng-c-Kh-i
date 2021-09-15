package _10_stack_queue.exercise.bracket_testing_with_stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        String string = "s * (s – a) * (s – b) * (s – c)";
        System.out.println(testBracket(string));
        string = "(– b + (b2 – 4*a*c)^0.5) / 2*a";
        System.out.println(testBracket(string));
        string = "s * (s – a) * (s – b * (s – c)";
        System.out.println(testBracket(string));
        string = "s * (s – a) * s – b) * (s – c)";
        System.out.println(testBracket(string));
        string = "(– b + (b^2 – 4*a*c)^(0.5/ 2*a))s ";
        System.out.println(testBracket(string));

    }

    public static boolean testBracket(String string) {
        System.out.println(string);
        String[] arrayString = string.split("");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i].equals("(")) {
                stack.push("(");
            } else if (arrayString[i].equals(")")) {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == "(") {
                        stack.pop();
                    } else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
