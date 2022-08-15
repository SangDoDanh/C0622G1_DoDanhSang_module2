package ss11_stack_queue.controller;

import java.util.Arrays;
import java.util.Stack;

public class ReverseNumbers {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        reverseIntegerUseStack(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    /**
     * Đổi ngược dãy số kiểu Integer
     * @param numbers dãy số kiểu int
     */
    static void reverseIntegerUseStack(int[] numbers) {
        Stack<Integer> stack = new Stack<>();
        for (int number : numbers) {
            stack.push(number);
        }
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = stack.pop();
        }
    }
}
