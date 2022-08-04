package ss3_array_and_method.exercise;

import java.util.Scanner;

public class SumDiagonalTwoArr {
    public static void main(String[] args) {
        // create 1 tow array m == n
        double[][] twoArr = createTwoArr(3,3);
        displayTwoArr(twoArr);
        System.out.println("Sum diagonal two array: " + sumDiagonal(twoArr));
    }

    static double sumDiagonal(double[][] twoArr) {
        double result = 0;
        for(int i = 0; i < twoArr.length; i++) {
            result += twoArr[i][i];
        }
        return result;
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
        for (double[] doubles : twoArr) {
            displayArr(doubles);
            System.out.println("");
        }
    }
}
