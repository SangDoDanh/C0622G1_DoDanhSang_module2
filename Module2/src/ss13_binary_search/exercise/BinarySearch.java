package ss13_binary_search.exercise;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Enter value: ");
        int value = Integer.parseInt(sc.nextLine());
        System.out.println(binarySearch(numbers, value, 0, numbers.length - 1));

    }

    static int binarySearch(int[] arr, int value, int start, int end) {
        if( start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
              return binarySearch(arr, value, mid + 1, end);
            }
            return binarySearch(arr, value, start, mid-1);
        }
        return -1;
    }
}
