package Module1.CollectionFramework;
import java.util.*;
public class Map123 {
    public static void main(String[] args){
        Map<Integer,String> m=new HashMap<>();
        m.put(1,"a");
        m.put(2,"b");
        m.put(3,"c");
        m.put(4,"d");
        System.out.println(m);
        m.remove(1);
        System.out.println(m);

    }
}
