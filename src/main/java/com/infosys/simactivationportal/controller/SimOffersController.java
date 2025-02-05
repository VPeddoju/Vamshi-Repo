package com.infosys.simactivationportal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/offers")
public class SimOffersController {

    @GetMapping("/{simId}/{serviceNumber}")
    public ResponseEntity<?> getSimOffers(@PathVariable Long simId, @PathVariable Long serviceNumber) {
        return ResponseEntity.ok("sent");
    }

}
