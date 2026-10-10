package Module1.OOPS_Basic;

public class Encapsulation {
    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Encapsulation obj = new Encapsulation();

        obj.setName("Arya");
        obj.setAge(21);

        System.out.println("Name: " + obj.getName());
        System.out.println("Age: " + obj.getAge());
    }
}
