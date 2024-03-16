package com.ivan.basicsecurityproject.controllers;

import com.ivan.basicsecurityproject.models.Customer;
import com.ivan.basicsecurityproject.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public LoginController(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer) {
        Customer savedCustomer = null;
        ResponseEntity response = null;
        try {
            // Encode the password before saving
            String encodedPassword = passwordEncoder.encode(customer.getPwd());
            customer.setPwd(encodedPassword);
            savedCustomer = customerRepository.save(customer);
            if (savedCustomer.getId() > 0) {
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Given user details are succesfully registered");
            } else {
                response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to register user details");
            }
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Exception occured dure to " + e.getMessage());
        }
        return response;
    }
}
