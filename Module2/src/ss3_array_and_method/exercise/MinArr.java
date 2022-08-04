package ss3_array_and_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MinArr {
    public static void main(String[] args) {
        // create a new arr2
        int[] arr = createArr(3);
        System.out.println(Arrays.toString(arr));
        System.out.printf("\nMin: %d", minArr(arr));
    }

    static int minArr(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    static int[] createArr(int n) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[n];
        System.out.println("Enter value for arr:");
        for (int i = 0; i < n; i++) {
            System.out.printf("\narr[%d] = ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        return arr;
    }
}
