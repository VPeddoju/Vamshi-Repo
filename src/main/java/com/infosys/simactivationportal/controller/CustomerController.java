package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.entity.ErrorResponse;
import com.infosys.simactivationportal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/customerapi")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/validate/{emailAddress}/{dob}")
    public ResponseEntity<?> validateCustomer(@PathVariable String emailAddress, @PathVariable String dob) {
        try {
            return ResponseEntity.ok(service.validateCustomer(emailAddress, dob));
        } catch (Exception e) {
                return ResponseEntity.ok(new ErrorResponse(LocalDateTime.now(),e.getMessage(),"send a valid request"));
        }
    }

    @PostMapping("/insertcustomer")
    public ResponseEntity<?> insertCustomerDetails(@RequestBody CustomerDto dto) {
        try {
            return ResponseEntity.ok(service.insertCustomer(dto));
        } catch (Exception e) {
            return ResponseEntity.ok(new ErrorResponse(LocalDateTime.now(),e.getMessage(),"send a valid request"));
        }
    }
}
