package ss11_stack_queue.controller;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PalindromeExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một chuỗi");
        String str = sc.nextLine();
        if(isPalindromeUseQueue(str)) {
            System.out.printf("%s: là Palindrome", str);
        } else {
            System.out.printf("%s: không phải chuỗi Palindrome", str);
        }
    }

    /**
     * Kiểm tra nếu một chuỗi là palindrome -> true, ngược lại false
     * @param str chuỗi muốn kiểm tra
     * @return true str là một chuỗi palindrome ngược lại false
     */
    static boolean isPalindromeUseQueue(String str) {
        Queue<String> palindromeQueue = new LinkedList<>();
        String strCharAt; // từng kí tự một trong str
        String strCharQueue; // từng phần tử trong palindromeQueue

        // tạo giá trị cho palindromeQueue
        for(int i = (str.length() - 1); i >= 0; i--) {
            palindromeQueue.offer(str.charAt(i)+"");
        }

        for(int i = 0; i < str.length(); i++) {
            strCharAt = str.charAt(i) + "";
            strCharQueue = palindromeQueue.poll();
            if(!strCharAt.equals(strCharQueue)) {
                return false;
            }
        }
        return true;
    }
}
