package _02_loop_in_java.practic;

import java.util.Scanner;


public class CheckPrime {
    public static void main(String[] args) {
        int n = inputANumber();
        System.out.println(n + (isPrime(n)?" is a prime" : " is not a prime"));
    }

    public  static int inputANumber() {
        Scanner sc = new Scanner(System.in);
        int number;
        System.out.println("Input a number");
        number = Integer.parseInt(sc.nextLine());
        return number;
    }

    public static boolean isPrime(int number){
        if(number <2){
            return false;
        }
        else{
            for(int i = 2; i < number; i++) {
                if(number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
