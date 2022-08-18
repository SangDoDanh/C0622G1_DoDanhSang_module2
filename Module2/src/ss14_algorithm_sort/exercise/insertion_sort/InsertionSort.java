package ss14_algorithm_sort.exercise.insertion_sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = {29,10,14,37,14};
        System.out.println("Mang ban dau:");
        System.out.println(Arrays.toString(numbers));
        insertionSort(numbers);
        System.out.println("Ket qua:");
        System.out.println(Arrays.toString(numbers));

    }
    public static void insertionSort(int[] list) {
        int size = list.length;
        for (int i = 0; i < size - 1; i++) {
            int min = list[i + 1];
            int j;
            for (j = i + 1 ; j > 0 && min < list[j-1]; j--) {
                list[j] = list[j - 1];
            }
            list[j] = min;
        }
    }
    static void display(int[] list) {
        for (int j : list) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}

