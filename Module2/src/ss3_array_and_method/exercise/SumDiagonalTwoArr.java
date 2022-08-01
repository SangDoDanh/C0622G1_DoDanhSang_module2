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
        double resultLeft = 0;
        double resultRight = 0;
        for(int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr[i].length; j++) {
                if(i == j) {
                    resultLeft += twoArr[i][j];
                }
                if(j == i * -1 + 2){
                    resultRight += twoArr[i][j];
                }
            }
        }
        return resultRight + resultLeft;
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
