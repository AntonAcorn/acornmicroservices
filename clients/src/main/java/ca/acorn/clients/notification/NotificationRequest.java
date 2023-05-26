package ca.acorn.clients.notification;

public record NotificationRequest(
        Integer toCustomerId,
        String message,
        String sender,
        String toCustomerEmail
) {
}
