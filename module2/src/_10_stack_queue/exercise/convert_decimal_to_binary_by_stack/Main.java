package _10_stack_queue.exercise.convert_decimal_to_binary_by_stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int decimal = 174;
        System.out.println(decimal + " convert from decimal to binary = " + convertDecimalToBinary(decimal));
        int binary = 10101110;
        System.out.println(binary + " convert from binary to decimal = " + convertBinaryToDecimal(binary));
        decimal = 35631;
        System.out.println(decimal + " convert from decimal to hex = " + convertDecimalToHex(decimal));
        String hex = "8B2F";
        System.out.println(hex + " convert from hex to decimal = " + convertHexToDecimal(hex));

    }

    public static int convertDecimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }
        String string = "";
        while (!stack.isEmpty()) {
            string += stack.pop();
        }
        return Integer.parseInt(string);
    }

    public static int convertBinaryToDecimal(int binary) {
        int decimal = 0;
        String string = String.valueOf(binary);
        String[] arrayString = string.split("");
        int size = arrayString.length;
        for (int i = 0; i < arrayString.length; i++) {
            decimal += Integer.parseInt(arrayString[i]) * (Math.pow(2, (size - 1 - i)));
        }
        return decimal;
    }

    public static String convertDecimalToHex(int decimal) {
        Stack<String> stack = new Stack<>();
        int remainder;
        while (decimal != 0) {
            remainder = decimal % 16;
            switch (remainder) {
                case 10:
                    stack.push("A");
                    break;
                case 11:
                    stack.push("B");
                    break;
                case 12:
                    stack.push("C");
                    break;
                case 13:
                    stack.push("D");
                    break;
                case 14:
                    stack.push("E");
                    break;
                case 15:
                    stack.push("F");
                    break;
                default:
                    stack.push(String.valueOf(remainder));
            }
            decimal /= 16;
        }
        String string = "";
        while (!stack.isEmpty()) {
            string += stack.pop();
        }
        return string;
    }

    public static int convertHexToDecimal(String hex) {
        int decimal = 0;
        String[] arrayString = hex.split("");
        int size = arrayString.length;
        for (int i = 0; i < arrayString.length; i++) {
            switch (arrayString[i]) {
                case "A":
                    decimal += 10 * (Math.pow(16, (size - 1 - i)));
                    break;
                case "B":
                    decimal += 11 * (Math.pow(16, (size - 1 - i)));
                    break;
                case "C":
                    decimal += 12 * (Math.pow(16, (size - 1 - i)));
                    break;
                case "D":
                    decimal += 13 * (Math.pow(16, (size - 1 - i)));
                    break;
                case "E":
                    decimal += 14 * (Math.pow(16, (size - 1 - i)));
                    break;
                case "F":
                    decimal += 15 * (Math.pow(16, (size - 1 - i)));
                    break;
                default:
                    decimal += Integer.parseInt(arrayString[i]) * (Math.pow(16, (size - 1 - i)));
            }
        }
        return decimal;
    }
}
