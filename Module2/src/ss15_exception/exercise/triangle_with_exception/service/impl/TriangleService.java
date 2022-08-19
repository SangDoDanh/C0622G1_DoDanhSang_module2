package ss15_exception.exercise.triangle_with_exception.service.impl;

import ss15_exception.exercise.triangle_with_exception.model.Triangle;
import ss15_exception.exercise.triangle_with_exception.service.ITriangleService;
import ss15_exception.exercise.triangle_with_exception.service.utils.IllegalTriangleException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TriangleService implements ITriangleService {
    private final List<Triangle> triangles = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    /**
     * thêm mới một triangle vào triangles
     */
    @Override
    public void add() {
        Triangle triangle = createTriangle();
        triangles.add(triangle);
    }

    /**
     * hiển thị các phần tử có trong triangles
     */
    @Override
    public void display() {
        if(triangles.size() == 0) {
            System.out.println("Danh sách trống!");
        } else {
            show(triangles);
        }
    }

    @Override
    public void inIt() {
        triangles.add(new Triangle(3, 4,5));
        triangles.add(new Triangle(4, 5, 7));
    }

    private void show(List<Triangle> triangles) {
        for(Triangle triangle : triangles) {
            System.out.println(triangle);
        }
    }

    /**
     * yêu cầu người dùng nhập thông tin các cạnh cho một triangle sau đó
     * tạo mới một triangle dựa trên thông tin đã nhập
     * @return triangle
     */
    private Triangle createTriangle() {
        int a;
        int b;
        int c;
        boolean isTriangle;
        boolean isLessThanZero;
        while (true) {
            try {
                System.out.println("Nhập độ dài các cạnh của tam giác:");
                System.out.print("a: ");
                a = Integer.parseInt(sc.nextLine());
                System.out.print("b: ");
                b = Integer.parseInt(sc.nextLine());
                System.out.print("c: ");
                c = Integer.parseInt(sc.nextLine());
                isTriangle = isTriangle(a, b, c);
                isLessThanZero = !isGreaterZero(a, b, c);
                if (!isTriangle || isLessThanZero) {
                    throw new IllegalTriangleException("Các cạnh là số nguyên dương & tổng hai cạnh phải lớn hơn 1 cạnh!");
                }
                break;
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                System.out.println("Vui lòng nhập đúng định dạng số");
            } catch (Exception e) {
                System.out.println("bất lực!");
            }
        }
        return new Triangle(a, b, c);

    }

    /**
     * kiểm tra ba cạnh của tam giác có lớn hơn 0 ?
     * @param a cạnh a
     * @param b cạnh b
     * @param c cạnh c
     * @return a, b, c > 0 -> true, một trong 3 cạnh bé hơn 0 -> flase
     */
    private boolean isGreaterZero(int a, int b, int c) {
        return a > 0 && b > 0 && c > 0;
    }

    /**
     * Tổng hai cạnh lớn hơn cạnh còn lại thì true, ngược lại fasle
     * @param a cạnh a của triangle
     * @param b cạnh b của triangle
     * @param c cạnh c của triangle
     * @return true or false
     */
    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
}
