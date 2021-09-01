package _01_introduction_to_java.exercise;

import java.util.Scanner;

public class ConvertNumerToString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input a positive number(has max 3 digits)");
        int n = sc.nextInt();
        String str = "";
        System.out.println(n);
        if(n < 0 || n >1000){
            System.out.println("Invalid input number");
        }
        else if(n < 10){
            switch (n){
                case 0:
                    str = "Zero";break;
                case 1:
                    str = "One";break;
                case 2:
                    str = "Two";break;
                case 3:
                    str = "Three";break;
                case 4:
                    str = "Four";break;
                case 5:
                    str = "Five";break;
                case 6:
                    str = "Six";break;
                case 7:
                    str = "Seven";break;
                case 8:
                    str = "Eight";break;
                case 9:
                    str = "Nine";break;
            }
        }
        else if(n < 20){
            switch (n){
                case 10:
                    str = "Ten";break;
                case 11:
                    str = "Eleven";break;
                case 12:
                    str = "Twelve";break;
                case 13:
                    str = "Thirdteen";break;
                case 14:
                    str = "Fourteen";break;
                case 15:
                    str = "Fifteen";break;
                case 16:
                    str = "Sixteen";break;
                case 17:
                    str = "Seventeen";break;
                case 18:
                    str = "Eighteen";break;
                case 19:
                    str = "Nineteen";break;
            }
        }

        else if(n<100){
            switch (n/10){
                case 2:
                    str = "Twenty ";break;
                case 3:
                    str = "Thirty ";break;
                case 4:
                    str = "Fourty ";break;
                case 5:
                    str = "Fifty ";break;
                case 6:
                    str = "Sixty ";break;
                case 7:
                    str = "Seventy ";break;
                case 8:
                    str = "Eighty ";break;
                case 9:
                    str = "Ninety ";break;
            }
            switch (n%10){
                case 0: break;
                case 1:
                    str += "one ";break;
                case 2:
                    str += "two ";break;
                case 3:
                    str += "three ";break;
                case 4:
                    str += "four ";break;
                case 5:
                    str += "five ";break;
                case 6:
                    str += "six ";break;
                case 7:
                    str += "seven ";break;
                case 8:
                    str += "eight ";break;
                case 9:
                    str += "nine ";break;
            }
        }

        else if(n<1000){
            switch (n/100){
                case 1:
                    str = "One hundred ";break;
                case 2:
                    str = "Two hundred ";break;
                case 3:
                    str = "Three hundred ";break;
                case 4:
                    str = "Four hundred ";break;
                case 5:
                    str = "Five hundred ";break;
                case 6:
                    str = "Six hundred ";break;
                case 7:
                    str = "Seven hundred ";break;
                case 8:
                    str = "Eigh hundred ";break;
                case 9:
                    str = "Nine hundred ";break;
            }
            switch ((n/10)%10){
                case 0: break;
                case 1:
                    switch (n%100){
                        case 10:
                            str += "and en";break;
                        case 11:
                            str += "and eleven";break;
                        case 12:
                            str += "and twelve";break;
                        case 13:
                            str += "and thirdteen";break;
                        case 14:
                            str += "and fourteen";break;
                        case 15:
                            str += "and fifteen";break;
                        case 16:
                            str += "and sixteen";break;
                        case 17:
                            str += "and seventeen";break;
                        case 18:
                            str += "and eighteen";break;
                        case 19:
                            str += "and nineteen";break;
                    }
                    break;
                case 2:
                    str += "and twenty ";break;
                case 3:
                    str += "and thirty ";break;
                case 4:
                    str += "and fourty ";break;
                case 5:
                    str += "and fifty ";break;
                case 6:
                    str += "and sixty ";break;
                case 7:
                    str += "and seventy ";break;
                case 8:
                    str += "and eighty ";break;
                case 9:
                    str += "and ninety ";break;
            }
            switch ((n%100)%10){
                case 0: break;
                case 1:
                    str += "one ";break;
                case 2:
                    str += "two ";break;
                case 3:
                    str += "three ";break;
                case 4:
                    str += "four ";break;
                case 5:
                    str += "five ";break;
                case 6:
                    str += "six ";break;
                case 7:
                    str += "seven ";break;
                case 8:
                    str += "eigh ";break;
                case 9:
                    str += "nine ";break;
            }
        }
        System.out.println(str);
    }
}
