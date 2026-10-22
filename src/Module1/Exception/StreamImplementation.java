package Module1.Exception;

import java.util.ArrayList;

public class StreamImplementation {
    public static void main(String[] args) {
        ArrayList<Integer>l=new ArrayList<>();
        ArrayList<String>s=new ArrayList<>();
        l.add(6);
        l.add(5);
        s.add("hello");
        s.add("world");
        s.add("rahul");
        s.add("rajul");
        s.stream().filter(st->st.startsWith("r")&&st.endsWith("l")).forEach(System.out::println);
        l.add(10);
        l.stream().map(i->i*2).forEach(System.out::println);
        l.stream().sorted().forEach(System.out::println);



    }
}
