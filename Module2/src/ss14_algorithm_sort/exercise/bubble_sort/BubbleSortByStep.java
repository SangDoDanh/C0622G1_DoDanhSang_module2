package ss14_algorithm_sort.exercise.bubble_sort;

import java.util.Scanner;

public class BubbleSortByStep {
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
        bubbleSortByStep(numbers); //bubble sort
        System.out.println("Mảng sau khi bubble sort:");
        display(numbers);

    }
    public static void bubbleSortByStep(int[] list) {
        boolean isSwap = true;
        int size = list.length;
        System.out.println("Các bước chuyển:");
        for(int i = 0; i < size && isSwap; i++) {
            isSwap = false;
            for(int j = 0; j < size - 1 - i; j++) {
                if(list[j] > list[j + 1]) {
                    isSwap = true;
                    int temp = list[j];
                    list[j] = list[j+ 1];
                    list[j + 1] = temp;
                }
            }
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
