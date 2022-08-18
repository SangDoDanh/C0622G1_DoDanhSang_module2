package ss14_algorithm_sort.exercise.sellection_sort;

import java.util.Scanner;

public class SelectionSortByStep {
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
        selectionSortByStep(numbers); //bubble sort
        System.out.println("Mảng sau khi selection sort:");
        display(numbers);
    }

    private static void selectionSortByStep(int[] numbers) {
        int size = numbers.length;
        int minIndex;
        System.out.println("Các bước chuyển:");
        for(int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                int temp = numbers[i];
                numbers[i] = numbers[minIndex];
                numbers[minIndex] = temp;
            }
            display(numbers);
        }
    }

    static void display(int[] list) {
        for (int j : list) {
            System.out.print(j + "\t");
        }
        System.out.println();
    }
}
