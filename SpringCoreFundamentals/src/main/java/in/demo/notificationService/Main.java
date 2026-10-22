package in.demo.notificationService;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Student student = context.getBean(Student.class);
        Student student1 = context.getBean(Student.class);
        System.out.println(student.hashCode());
        System.out.println(student1.hashCode());
        System.out.println(student == student1);
        student.notifyStudnet();
        context.close();
    }
}