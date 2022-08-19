package demo;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = {29,10,14,37,143, 5,7, 32,65, 3, 699};
        selectionSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void selectionSort(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size -1; i++) {
            int min = i;
            for(int j = i + 1; j < size; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
