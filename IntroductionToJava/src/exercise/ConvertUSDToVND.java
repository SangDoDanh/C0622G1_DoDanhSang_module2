package exercise;

import java.util.Scanner;

public class ConvertUSDToVND {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double RATE = 23000;
        System.out.print("USD: ");
        double usd = sc.nextDouble();
        System.out.println((usd * RATE) + " VND");
    }
}
