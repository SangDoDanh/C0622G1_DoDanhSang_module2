package exercise;

import java.util.Scanner;

public class ReadDigistIntoLeters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if(number < 10) {
            System.out.println(readOneNumber(number));
        } else if(number < 99) {
            System.out.println(readTowNumber(number));
        } else if(number < 1000) {
            System.out.println(readThreeNumber(number));
        } else {
            System.out.println("out of ability");
        }
    }

    public static  String readOneNumber(int number) {
        String[] numbersString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        return  numbersString[number];
    } // end ReadOneNumber

    public static  String readTowNumber(int number) {
        switch (number) {
            case 10:
                return  "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 20:
               return "twenty";
            case 50:
                return "fifty";
        }
        if(number < 10) {
            return readOneNumber(number);
        } else if(number < 20) {
            return readOneNumber(number) + "teen";
        } else if(number % 10 == 0) {
            return readOneNumber(number/10) + "ty";
        }
        int number1 = number / 10;
        int number2 = number % 10;
        if(number1 == 2) {
            return  "twenty " + readOneNumber(number2);
        } else if(number1 == 5){
            return  "fifty" + readOneNumber(number2);
        }
        return  readOneNumber(number1) + "ty " + readOneNumber(number2);
    } // end ReadTowNumber

    public static String readThreeNumber(int number) {
        if(number / 100 == 0) {
            return readOneNumber(number/100) + " hundred";
        }
        return readOneNumber(number/100) + " hundred and " + readTowNumber(number%100);
    }

}
