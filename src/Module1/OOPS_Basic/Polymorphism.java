package Module1.OOPS_Basic;

class Parent {
    void show() {
        System.out.println("Parent class method");
    }
}

public class Polymorphism extends Parent {
    @Override
    void show() {
        System.out.println("Child class method");
    }

    public static void main(String[] args) {
        Parent obj = new Polymorphism();
        obj.show();
    }
}
