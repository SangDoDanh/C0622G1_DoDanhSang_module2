package demo;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {

        int[] a = {29, 10, 14, 37, 143, 5, 7, 32, 65, 3, 699};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    static void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int min = arr[i + 1];
            int j;
            for (j = i + 1; j > 0 && arr[j - 1] > min; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = min;
        }
    }

}
