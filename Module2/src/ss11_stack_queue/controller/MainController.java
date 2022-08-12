package ss11_stack_queue.controller;

import java.util.Arrays;
import java.util.Stack;

public class MainController {
    public static void main(String[] args) {
        /**
         * numbers : mảng các số nguyên
         */
        int[] numbers = new int[]{1, 2, 3, 4, 5};
        reverseIntegerUseStack(numbers);
        System.out.println(Arrays.toString(numbers));

        String fullName = "DO DANH SANG";
        fullName = reverseStringUseStack(fullName);
        System.out.println(fullName);
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

    /**
     * đảo ngược một chuỗi và về chuỗi đã đổi ngược
     * @param str chuỗi muốn đảo ngược
     * @return str đã đảo ngược
     */
    static String reverseStringUseStack(String str) {
        Stack<String> stack = new Stack<>();
        final int STR_LENGTH = str.length();
        for (int i = 0; i < STR_LENGTH; i++) {
            stack.push(str.charAt(i) + "");
        }
        str = "";
        for(int i = 0; i < STR_LENGTH; i++) {
            str += stack.pop();
        }
        return str;
    }
}
