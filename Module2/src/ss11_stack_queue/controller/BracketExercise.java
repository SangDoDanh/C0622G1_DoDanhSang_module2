package ss11_stack_queue.controller;

import java.util.Scanner;
import java.util.Stack;

public class BracketExercise {
    public static void main(String[] args) {

        System.out.println(checkBracket("s * (s – a) * (s – b * (s – c)"));
    }
    static boolean checkBracket(String str) {
        Stack<Character> brackets = new Stack<>();
        char sym;
        for(int i = 0; i < str.length(); i++) {
             sym = str.charAt(i);
            if(str.charAt(i) == '(') {
                brackets.push(sym);
            }
            if(sym == ')') {
                if(brackets.isEmpty()) {
                    return false;
                } else if(brackets.pop() != '('){
                    return false;
                }
            }
        }
        return brackets.isEmpty();
    }
}
