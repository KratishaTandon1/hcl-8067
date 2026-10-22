package in.demo.notificationService;

public class WhatsappService implements NotificationService {
    @Override
    public void sendMsg(String msg) {
        System.out.println("Whatsapp sent: " + msg);
    }

}