package ss2_loop_to_java.exercise;

import java.util.Scanner;

public class Shape {
    public static void main(String[] args) {
        menu();
    }

    static void printRect() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Width: ");
        int width = sc.nextInt();
        System.out.print("\nHeight: ");
        int height = sc.nextInt();

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void printSquareTriangle() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Height triangle: ");
        int heightTriangle = sc.nextInt();
        // top left
        for (int i = heightTriangle; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

        // bottom-left
        for (int i = 1; i <= heightTriangle; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void printIsoscelesTriangle() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Height triangle:");
        int heightTriangle = sc.nextInt();

        for (int i = 1; i < heightTriangle; i++) {
            for (int j = 1; j <= i * -1 + heightTriangle; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    static void exit() {
        System.exit(0);
    }

    static void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            int chose = sc.nextInt();
            switch (chose) {
                case 1:
                    printRect();
                    break;
                case 2:
                    printSquareTriangle();
                    break;
                case 3:
                    printIsoscelesTriangle();
                    break;
                case 4:
                    exit();
                    break;
            }

        }
    }
}
