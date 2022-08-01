package ss2_loop_to_java.exercise;

public class Prime {
    public static void main(String[] args) {
        displayTwentyPrimes(20);
    }
    static void displayTwentyPrimes(int amount) {
        int count = 1;
        int numberPrime = 2;
        while (count <= amount) {
            if(isPrime(numberPrime)) {
                System.out.print(numberPrime + "\t");
                count ++;
            }
            numberPrime ++;
        }
    }

    static boolean isPrime(int number) {
        if(number < 2) {
            return  false;
        }
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
