package ss2_loop_to_java.exercise;

public class PrimeTo100 {
    public static void main(String[] args) {
        displayPrimesToMax(100);
    }

    static  void displayPrimesToMax(int max) {
        for(int i = 2; i < max; i ++) {
            if(isPrime(i)) {
                System.out.print(i + "\t");
            }
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
