package ca.acorn.customer;

import ca.acorn.clients.fraud.FraudCheckResponse;
import ca.acorn.clients.fraud.FraudClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
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
        // todo: send notification
    }
}
