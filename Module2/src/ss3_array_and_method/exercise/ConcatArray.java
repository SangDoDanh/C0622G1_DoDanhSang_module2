package ss3_array_and_method.exercise;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ConcatArray {
    public static void main(String[] args) {
        System.out.println("Enter value for arr1");
        int[] arr1 = createArr(3);
        System.out.println("Enter value for arr1");
        int[] arr2 = createArr(2);
        int[] arrConcat = concatArray(arr1, arr2);
        displayArr(arrConcat);
    }

    static int[] createArr(int amount) {
        Scanner sc = new Scanner(System.in);
        int[] result = new int[amount];
        for(int i = 0; i < amount; i++) {
            System.out.print("Enter value for element " + i + ": ");
            result[i] = sc.nextInt();
        }
        return result;
    }

    static  int[] concatArray(int[] arr1, int[] arr2) {
        int resultLength = arr1.length + arr2.length;
        int[] result = new int[resultLength];
        for(int i = 0; i < arr1.length; i ++) {
            result[i] = arr1[i];
        }
        int count = 0;
        for (int i = arr1.length; i < resultLength; i++) {
            result[i] = arr2[count];
            count ++;
        }
        return result;
    }
    static void displayArr(int[] arr) {
        for (int item: arr) {
            System.out.print(item + "\t");
        }
    }
}
