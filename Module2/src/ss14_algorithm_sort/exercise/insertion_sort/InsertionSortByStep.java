package ss14_algorithm_sort.exercise.insertion_sort;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        int[] numbers;
        System.out.print("Nhập kích thước mảng: ");
        size = Integer.parseInt(sc.nextLine());
        numbers = new int[size];
        for(int i = 0; i < size; i++) {
            System.out.printf("numbers[%d]: ", i);
            numbers[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng vừa tạo: ");
        display(numbers);
        insertionSort(numbers); //bubble sort
        System.out.println("Mảng sau khi selection sort:");
        display(numbers);

    }
    public static void insertionSort(int[] list) {
        System.out.println("Các bước thực hiện:");
        int size = list.length;
        for (int i = 0; i < size - 1; i++) {
            int min = list[i + 1];
            int j;
            for (j = i + 1 ; j > 0 && min < list[j-1]; j--) {
                list[j] = list[j - 1];
            }
            list[j] = min;
            display(list);
        }
    }
    static void display(int[] list) {
        for (int j : list) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
