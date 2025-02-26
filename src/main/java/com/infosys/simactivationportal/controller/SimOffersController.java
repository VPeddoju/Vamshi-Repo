package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.dto.SimOffersDto;
import com.infosys.simactivationportal.entity.ErrorResponse;
import com.infosys.simactivationportal.service.SimOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/offers")
public class SimOffersController {

    @Autowired
    SimOffersService simOffersService;

    @PostMapping("/insertSimOffers")
    public ResponseEntity<?> insertSimOffers(@RequestBody SimOffersDto simOffersDto){
        try{
            return ResponseEntity.ok(simOffersService.insertSimOffers(simOffersDto));
        }
        catch(Exception e){
            return ResponseEntity.ok(new ErrorResponse(LocalDateTime.now(),e.getMessage(),"send a valid request"));
        }
    }
}
