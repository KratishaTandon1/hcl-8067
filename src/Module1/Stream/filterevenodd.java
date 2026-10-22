package Module1.Stream;

import java.util.ArrayList;
import java.util.List;

public class filterevenodd {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.stream().filter(n -> n%2==0).forEach(n ->System.out.print(n + " "));
        System.out.println(list.stream().filter(n -> n%2==1).count());
    }
}