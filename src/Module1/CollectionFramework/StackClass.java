package Module1.CollectionFramework;
import java.util.*;
public class StackClass {
    public static void main(String[] args){
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        System.out.println(st);
        st.pop();
        System.out.println(st);
        System.out.println(st.peek());

        Deque<Integer> s=new ArrayDeque<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s);
        s.pop();
        System.out.println(s);
        System.out.println(s.peek());
    }
}
