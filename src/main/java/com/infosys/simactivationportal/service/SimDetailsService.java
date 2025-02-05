package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.Exceptions.SimNotFoundException;
import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.entity.SimOffers;
import com.infosys.simactivationportal.repository.SimDetailsRepository;
import com.infosys.simactivationportal.repository.SimOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimDetailsService {

    @Autowired
    private SimDetailsRepository simDetailsRepository;

    @Autowired
    private SimOffersRepository simOffersRepository;

    public SimOffers validateAndSendSimOffers(Long simNumber, Long serviceNumber) throws SimNotFoundException {
        Optional<SimDetails> optional = Optional.ofNullable(simDetailsRepository.findBySimNumberAndServiceNumber(simNumber, serviceNumber));
        if(optional.isPresent()){
            SimDetails details = optional.get();
            return details.getSimOffers();
        }
        else {
            throw new SimNotFoundException("sim not found with given sim number and service number");
        }
    }
}
