package demo_abstract.main;

import demo_abstract.B;

public class MainController {
    public static void main(String[] args) throws NoSuchMethodException {
        int[] a = {1, 2, 3,4 ,5};
        B b1 = new B();
        B b2 = new B();
        B b3 = new B();

        B anonymous = new B(){
            public void show() {
                System.out.println("Anonymous");
            }
            public void showStyle() {
                System.out.println("HEHEHE");
            }
        };
        B[] bs = new B[]{b1, b2, b3, anonymous};
//        for(B b :bs ) {
//            b.show();
//        }
    }

}
