package _02_loop_in_java.exercise;


public class PrintAllPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        System.out.println("print all prime numbers less than 100: ");
        int count = 0;
        int N = 0;
        while (N <= 100){
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
