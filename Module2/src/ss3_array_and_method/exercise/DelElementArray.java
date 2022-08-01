package ss3_array_and_method.exercise;

import java.lang.reflect.Array;
import java.util.Scanner;

public class DelElementArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value want to you DELETE: ");
        int valueDel = sc.nextInt();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        displayArr(numbers); // before delete
        delElementByValue(valueDel, numbers);
        System.out.println("");
        displayArr(numbers); // after delete
    }

    // Delete element by index
    static void delElementByIndex(int delIndex, int[] arr) {
       if(delIndex > arr.length || delIndex < 0) {
           System.out.println("Not delete!");
       } else {
           // delete 1 element
           for(int i = delIndex; i < arr.length -1; i++) {
               arr[i] = arr[i + 1];
           }
           arr[arr.length - 1] = 0;
       }

    }

    // delete element by value
    static void delElementByValue(int number, int[] arr) {
        int delIndex = findElement(number, arr);
        if( delIndex > -1) {
           delElementByIndex(delIndex, arr);
        }
    }

    // search element to array
    static int findElement(int number, int[] arr) {
        if(arr.length > 0) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == number) {
                    return i;
                }
            }
        }
        return  -1;
    }

    // show info arr
    static void displayArr(int[] arr) {
        for (int item: arr) {
            System.out.print(item + "\t");
        }
    }
}
