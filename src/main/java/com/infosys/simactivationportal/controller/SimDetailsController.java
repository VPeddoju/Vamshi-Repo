package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.entity.ErrorResponse;
import com.infosys.simactivationportal.service.SimDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/simapi")
public class SimDetailsController {

    @Autowired
    private SimDetailsService simDetailsService;

    @GetMapping("/{simNumber}/{serviceNumber}")
    public ResponseEntity<?> validateAndSendSimOffers(@PathVariable Long simNumber, @PathVariable Long serviceNumber){
        try{
            if(Long.toString(simNumber).length() == 10 && Long.toString(serviceNumber).length() == 6){
                return ResponseEntity.ok(simDetailsService.validateAndSendSimOffers(simNumber, serviceNumber));
            }
            else{
                throw new Exception("simNumber or serviceNumber does not meet length 10 or 6 respectively");
            }
        }
        catch(Exception e){
            ErrorResponse error = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "pass correct/valid details");
            return ResponseEntity.ok(error);
        }
    }
}
