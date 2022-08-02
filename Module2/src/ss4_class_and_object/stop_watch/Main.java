package ss4_class_and_object.stop_watch;


import static java.lang.System.currentTimeMillis;

public class Main {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(System.currentTimeMillis());
        calcFactorialDemo(200000000);
        stopWatch.stop(System.currentTimeMillis());
        System.out.println("Total times: " + stopWatch.getElapsedTime());

    }

    // factorial calculation
    static void calcFactorialDemo(int number) {
        double result = 1;
        for (int i = 2; i <= number; i++) {
            result = i;
        }
    }
}
