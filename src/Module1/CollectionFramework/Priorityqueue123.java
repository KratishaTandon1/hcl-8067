package Module1.CollectionFramework;
import java.util.*;
public class Priorityqueue123 {
    public static void main(String[] args){

        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(10);
        pq.offer(20);
        pq.offer(30);
        pq.offer(40);
        System.out.println(pq);
        pq.poll();
        System.out.println(pq);
        System.out.println(pq.peek());

        PriorityQueue<Integer> pq1=new PriorityQueue<>(Comparator.reverseOrder());
        pq1.offer(20);
        pq1.offer(10);
        pq1.offer(5);
        pq1.offer(30);
        System.out.println(pq1);
        pq1.poll();
        System.out.println(pq1);
        System.out.println(pq1.peek());

    }

}
