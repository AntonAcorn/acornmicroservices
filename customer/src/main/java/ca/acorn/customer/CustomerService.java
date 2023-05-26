package ca.acorn.customer;

import ca.acorn.clients.fraud.FraudCheckResponse;
import ca.acorn.clients.fraud.FraudClient;
import ca.acorn.clients.notification.NotificationClient;
import ca.acorn.clients.notification.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer); // flush needed to have id
        // todo: check if fraudster
        FraudCheckResponse response =
                fraudClient.isFraudster(customer.getId());

        if (response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        // todo: make async
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        "Hi %s, welcome to my service", customer.getFirstName()
                )
        );
    }
}
