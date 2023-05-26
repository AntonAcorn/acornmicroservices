package ca.acorn.notification;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    public void send(NotificationRequest notificationRequest) {
        Notification notification = Notification
                .builder()
                .toCustomerId()
                .toCustomerEmail()
                .sender()
                .message()
                .sent_at(LocalDateTime.now())
                .build();
    }
}
