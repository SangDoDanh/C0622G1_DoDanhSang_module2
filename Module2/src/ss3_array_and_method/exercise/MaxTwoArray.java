package ss3_array_and_method.exercise;

import java.util.Scanner;

public class MaxTwoArray {
    public static void main(String[] args) {
        // create 1 tow arr
        double[][] twoArr =  createTwoArr(3, 2);
        System.out.println("Info tow array:");
        displayTwoArr(twoArr);
        double max = maxTwoArr(twoArr);
        int mMax = findIndex(max, twoArr)[0];
        int nMax = findIndex(max, twoArr)[1];
        System.out.println("\nMax: " + max + " position: [" + mMax + ", " + nMax + "]");

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
    static double maxArr(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double number: arr) {
            max = Math.max(max, number);
        }
        return  max;
    }
    static double maxTwoArr(double[][] towArr) {
        double max = Double.MIN_VALUE;
        for(int i = 0; i < towArr.length; i++) {
            max = Math.max(max, maxArr(towArr[i]));
        }
        return  max;
    }

    static double[][] createTwoArr(int m, int n) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Create the towArr " + m + " row and " + n +" Col");
        double[][] newTowArr = new double[m][n];
        for (int i = 0; i < m; i++) {
            double[] newArr = new double[n];
            for(int j = 0; j < n; j ++) {
                System.out.println("Array[" + i+ "]["+j+"]: ");
                newArr[j] = Double.parseDouble(sc.nextLine());
            }
            newTowArr[i] = newArr;
        }
        return newTowArr;
    }
    static void displayArr(double[] arr) {
        for (double item: arr) {
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
