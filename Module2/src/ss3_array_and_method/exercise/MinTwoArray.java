package ss3_array_and_method.exercise;

import java.util.Scanner;

public class MinTwoArray {
    public static void main(String[] args) {
        // create 1 tow arr
        double[] arr =  createArr(3);
        System.out.println("Info tow array:");
        displayArr(arr);
        double min = minArr(arr);

        System.out.printf("\nMin: %f", min);
    }
    static  double[] createArr(int n) {
        double[] result = new double[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            System.out.printf("arr[%d]", i);
            result[i] = Double.parseDouble(sc.nextLine());
        }
        return result;
    }

    static void displayArr(double[] arr) {
        for (double item: arr) {
            System.out.print(item + "\t");
        }
    }

    static double minArr(double[] arr) {
        double min = Double.MAX_VALUE;
        for(double item: arr) {
            min = Math.min(item, min);
        }
        return min;
    }
}
