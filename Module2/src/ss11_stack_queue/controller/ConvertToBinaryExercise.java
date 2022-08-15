package ss11_stack_queue.controller;

import java.util.Scanner;
import java.util.Stack;

public class ConvertToBinaryExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> binaryStack = new Stack<>();
        int decimalNumber;

        System.out.println("Nhập vào một số thập phân: ");
        decimalNumber = Integer.parseInt(sc.nextLine());
        while(decimalNumber != 0) {
            binaryStack.add(decimalNumber % 2);
            decimalNumber /= 2;
        }
        System.out.print("Số nhị phân: ");
        while (!binaryStack.isEmpty()) {
            System.out.print(binaryStack.pop());
        }
    }


}
