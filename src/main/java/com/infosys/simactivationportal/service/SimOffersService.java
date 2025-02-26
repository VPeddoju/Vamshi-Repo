package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.dto.SimDetailsDto;
import com.infosys.simactivationportal.dto.SimOffersDto;
import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.entity.SimOffers;
import com.infosys.simactivationportal.repository.SimDetailsRepository;
import com.infosys.simactivationportal.repository.SimOffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimOffersService {

    @Autowired
    private SimOffersRepository simOffersRepository;

    @Autowired
    private SimDetailsRepository simDetailsRepository;

    public SimOffersDto insertSimOffers(SimOffersDto simOffersDto){
        Optional<SimDetails> optional = Optional.ofNullable(simOffersDto.getSimDetails());
        if(optional.isPresent()){
            SimDetails simDetails = optional.get();
            simDetailsRepository.save(simDetails);
            SimOffers simOffers = new SimOffers();
            return simOffersDto.prepareDtoObject(simOffersRepository.save(simOffers.prepareEntityObject(simOffersDto)));
        }
        else{
            throw new RuntimeException("provide sim details along with sim offers");
        }
    }
}
