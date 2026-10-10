package Module1.CollectionFramework;

import java.util.*;

public class Linked {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.push(10);
        list.push(20);
        list.push(30);
        System.out.println(list);
        list.pop();
        System.out.println(list);
    }
}
