package demo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {3, 5,7, 32,65, 3, 699};

bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void bubbleSort(int[] arr) {
        int size = arr.length;
        boolean isSwap = true;
        for(int i = 0; i < size-1 && isSwap; i++) {
            isSwap = false;
            for(int j = 0; j < size -1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    isSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
