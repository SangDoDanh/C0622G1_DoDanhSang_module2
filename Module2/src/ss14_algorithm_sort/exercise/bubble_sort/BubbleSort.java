package ss14_algorithm_sort.exercise.bubble_sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = {3, 1, -2, 5, 9, 1, 0};
        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void bubbleSort(int[] list) {
        boolean isSwap = true;
        int length = list.length;

        for(int i = 0; i < length && isSwap; i++) {
            isSwap = false;
            for(int j = 0; j < length - 1 - i; j++) {
                if(list[j] > list[j + 1]) {
                    isSwap = true;
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

    }
}
