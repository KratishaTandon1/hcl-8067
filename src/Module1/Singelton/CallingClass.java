package Module1.Singelton;

public class CallingClass {
    public static void main(String[] args) {
        SingleObject obj = SingleObject.createInstance();
        System.out.println(obj.hashCode());
        System.out.println(SingleObject.obj.hashCode());
        System.out.println(obj.equals(SingleObject.obj));
    }
}