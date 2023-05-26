package ca.acorn.notification;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("{customerId}")
    public Notification sendNotification(
            @PathVariable Integer customerId){
        notificationService.sendNotification(customerId);
        log.info("notification sent to customer {}", customerId);
        return new Notification();
    }

}
