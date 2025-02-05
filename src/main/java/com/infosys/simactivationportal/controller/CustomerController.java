package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customerapi")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/validate/{emailAddress}/{dob}")
    public ResponseEntity<?> validateCustomer(@PathVariable String emailAddress, @PathVariable String dob) {
        return ResponseEntity.ok(service.validateCustomer(emailAddress,dob));
    }

    @PostMapping("/insertcustomer")
    public ResponseEntity<?> insertCustomerDetails(@RequestBody CustomerDto dto) {
        return ResponseEntity.ok(service.insertCustomer(dto));
    }
}
