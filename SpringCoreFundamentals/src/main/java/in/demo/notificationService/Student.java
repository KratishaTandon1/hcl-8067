package in.demo.notificationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope("prototype")
public class Student {
    private final NotificationService notificationService;

    @Autowired
    public Student(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void notifyStudnet() {
        notificationService.sendMsg("Hello Student, you have a new notification!");
    }

    @PostConstruct
    public void init() {
        System.out.println("Student bean has been initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Student bean has been destroyed.");
    }
}