package ss3_array_and_method.exercise;

import java.util.Scanner;

public class SumColValueOfTwoArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // create 1 tow array
        double[][] twoArr = createTwoArr(3, 2);
        displayTwoArr(twoArr);
        System.out.println("Enter col want to sum: ");
        int col = Integer.parseInt(sc.nextLine());
        while (col > twoArr.length || col < 1) {
            System.out.println("Enter col again: ");
            col = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Sum: " + sumCol(twoArr, col));
    }
    static double sumCol(double[][] twoArr, int col) {
        double sum = 0;
        for(int i = 0; i < twoArr.length; i++) {
            sum += twoArr[i][col-1];
        }
        return sum;
    }

    static double[][] createTwoArr(int m, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create the towArr " + m + " row and " + n + " Col");
        double[][] newTowArr = new double[m][n];
        for (int i = 0; i < m; i++) {
            double[] newArr = new double[n];
            for (int j = 0; j < n; j++) {
                System.out.println("Array[" + i + "][" + j + "]: ");
                newArr[j] = Double.parseDouble(sc.nextLine());
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
