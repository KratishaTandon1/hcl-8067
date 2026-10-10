package Module1.CollectionFramework;
import java.util.*;
public class QueueClass {
    public static void main(String[] args){
        Queue<Integer>q=new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        System.out.println(q);
        q.poll();
        System.out.println(q);
        q.offer(1);
        System.out.println(q);
        Queue<Integer> q1=new ArrayDeque<>();
        q1.offer(10);
        q1.offer(20);
        q1.offer(30);
        q1.offer(40);
        System.out.println(q1);
        q1.poll();
        System.out.println(q1);
        q1.offer(10);
        System.out.println(q1);
    }
}
