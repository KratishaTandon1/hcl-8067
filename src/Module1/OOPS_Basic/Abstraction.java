package Module1.OOPS_Basic;

abstract class Shape {
    abstract void draw();
}

public class Abstraction extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }

    public static void main(String[] args) {
        Abstraction obj = new Abstraction();
        obj.draw();
    }
}
