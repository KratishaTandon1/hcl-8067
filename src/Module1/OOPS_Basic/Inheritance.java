package Module1.OOPS_Basic;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

public class Inheritance extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }

    public static void main(String[] args) {
        Inheritance obj = new Inheritance();

        obj.eat();
        obj.bark();
    }
}
