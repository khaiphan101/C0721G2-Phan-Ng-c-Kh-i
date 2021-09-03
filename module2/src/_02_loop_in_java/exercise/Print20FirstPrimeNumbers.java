package _02_loop_in_java.exercise;

import java.util.Scanner;

public class Print20FirstPrimeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter amount of first prime number ");
        int amount = sc.nextInt();
        int count = 0;
        int N = 0;
        while(count < amount){
            if(isPrime(N)){
                System.out.print(N + ", ");
                count++;
            }
            N++;
        }
        System.out.println("count = " + count);
    }

    static boolean isPrime(int number){
        if(number < 2){
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
