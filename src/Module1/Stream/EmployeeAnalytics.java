package Module1.Stream;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAnalytics {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Shivansh");
        list.add("Vishal");
        list.add("Satyam");
        list.add("Tushar");
        list.stream().filter(n -> (n.startsWith("S") && n.endsWith("h"))).forEach(n -> System.out.println(n));
        list.stream().map(
                n -> "Mr.".concat(n)).forEach(System.out::println);
        list.stream().sorted().forEach(System.out::println);
        System.out.println(list.stream().reduce((a,b) -> a+b));
    }
}