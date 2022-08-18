package ss14_algorithm_sort.exercise.sellection_sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = {3, 32, 356, -234, 23, 7};
        System.out.println(Arrays.toString(numbers));
        System.out.println("Selection sort");
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    static void selectionSort(int[] list) {
        int size = list.length;
        int minIndex;
        for(int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (list[minIndex] > list[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }
}
