package Module1.Singelton;

public class SingleObject {
    private SingleObject(){};
    static final SingleObject obj = new SingleObject();
    static SingleObject createInstance(){
        return obj;
    }
}