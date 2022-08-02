package ss4_class_and_object.quadratic_equation;

public class Main {
    public static void main(String[] args) {
        QuadraticEquation qe1 = new QuadraticEquation(1, 2, 1);
        if(qe1.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if(qe1.getDiscriminant() > 0){
            System.out.printf("X1 = %.2f\nX2 = %.2f", qe1.getRoot1(), qe1.getRoot2());
        } else {
            System.out.printf("X1 = X2 = %.2f", qe1.getRoot1());
        }
    }
}
