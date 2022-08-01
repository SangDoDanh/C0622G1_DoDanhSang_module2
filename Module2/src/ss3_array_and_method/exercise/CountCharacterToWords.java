package ss3_array_and_method.exercise;

import java.util.Scanner;

public class CountCharacterToWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String words = "C0622G1";
        System.out.println("Enter a character: ");
        String c = sc.next();
        int count = countCharacter(words, c.charAt(0));
        System.out.println("Count " + c + ": " + count);
    }
    static int countCharacter(String words, char c) {
        int count = 0;
        for(int i = 0; i < words.length(); i++) {
            if(Character.compare(words.charAt(i), c) == 0) {
                count ++;
            }
        }
        return  count;
    }
}
