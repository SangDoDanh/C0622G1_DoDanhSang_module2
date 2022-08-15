package demo_abstract;

public class B {
    public void show(){
        System.out.println("B");
    }
    public Class<? extends B> getMe() {
        return this.getClass();
    }
}
