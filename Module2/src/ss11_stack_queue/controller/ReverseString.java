package ss11_stack_queue.controller;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {

        String fullName = "DO DANH SANG";
        fullName = reverseStringUseStack(fullName);
        System.out.println(fullName);
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
        for (int i = 0; i < STR_LENGTH; i++) {
            str += stack.pop();
        }
        return str;
    }
}
