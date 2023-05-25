package ca.acorn.fraud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud")
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    public FraudCheckController(FraudCheckService fraudCheckService) {
        this.fraudCheckService = fraudCheckService;
    }

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(
            @PathVariable ("customerId") Integer customerId){
        boolean isFraudulentCustomer = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
