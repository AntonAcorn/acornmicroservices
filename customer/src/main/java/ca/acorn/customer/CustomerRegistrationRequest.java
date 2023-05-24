package ca.acorn.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
