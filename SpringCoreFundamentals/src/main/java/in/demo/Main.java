package in.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            Employee employee = context.getBean(Employee.class);
            Employee employee1 = context.getBean(Employee.class);
            System.out.println(employee.hashCode());
            System.out.println(employee1.hashCode());
        }
    }
}