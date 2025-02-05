package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.dto.CustomerAddressDto;
import com.infosys.simactivationportal.entity.ErrorResponse;
import com.infosys.simactivationportal.service.CustomerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/Address")
public class CustomerAddressController {

    @Autowired
    CustomerAddressService service;

    @PutMapping
    public ResponseEntity<?> updateCustomerAddress(@RequestBody CustomerAddressDto dto){
        try {
            return ResponseEntity.ok(service.updateCustomerAddress(dto));
        }
        catch(RuntimeException e){
            ErrorResponse error = new ErrorResponse(LocalDateTime.now(),e.getMessage(),"send valid customer");
            return ResponseEntity.ok(error);
        }
    }
}
