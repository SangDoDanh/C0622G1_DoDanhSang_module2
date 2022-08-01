package ss3_array_and_method.exercise;

import java.util.Scanner;

public class MinTwoArray {
    public static void main(String[] args) {
        // create 1 tow arr
        double[][] twoArr =  createTwoArr(3, 2);
        System.out.println("Info tow array:");
        displayTwoArr(twoArr);
        double min = minTwoArr(twoArr);
        int mMin = findIndex(min, twoArr)[0];
        int nMin = findIndex(min, twoArr)[1];
        System.out.println("\nMin: " + min + " position: [" + mMin + ", " + nMin +"]");
    }
    static int[] findIndex(double number, double[][] twoArr) {
        for(int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr[i].length; j++) {
                if(twoArr[i][j] == number){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    static double minArr(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double number : arr) {
            min = Math.min(min, number);
        }
        return min;
    }

    static double minTwoArr(double[][] towArr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < towArr.length; i++) {
            min = Math.min(min, minArr(towArr[i]));
        }
        return min;
    }

    static double[][] createTwoArr(int m, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create the towArr " + m + " row and " + n + " Col");
        double[][] newTowArr = new double[m][n];
        for (int i = 0; i < m; i++) {
            double[] newArr = new double[n];
            for (int j = 0; j < n; j++) {
                System.out.println("Array[" + i + "][" + j + "]: ");
                newArr[j] = sc.nextDouble();
            }
            newTowArr[i] = newArr;
        }
        return newTowArr;
    }

    static void displayArr(double[] arr) {
        for (double item : arr) {
            System.out.print(item + "\t");
        }
    }

    static void displayTwoArr(double[][] twoArr) {
        for (int i = 0; i < twoArr.length; i++) {
            displayArr(twoArr[i]);
            System.out.println("");
        }
    }
}
