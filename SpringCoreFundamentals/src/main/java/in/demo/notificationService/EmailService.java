package in.demo.notificationService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class EmailService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("Email sent: " + msg);
    }

}