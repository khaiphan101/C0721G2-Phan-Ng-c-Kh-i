package _02_loop_in_java.exercise;


public class PrintAllPrimeNumbersLessThan100 {
    public static void main(String[] args) {
        System.out.println("print all prime numbers less than 100: ");
        int count = 0;
        for(int i = 1; i < 100; i++){
            if(isPrime(i)){
                System.out.print(i + ", ");
                count++;
            }
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
