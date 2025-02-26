package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.Exceptions.SimNotFoundException;
import com.infosys.simactivationportal.dto.SimOffersDto;
import com.infosys.simactivationportal.entity.ErrorResponse;
import com.infosys.simactivationportal.entity.SimOffers;
import com.infosys.simactivationportal.service.SimDetailsService;
import com.infosys.simactivationportal.service.SimOffersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimOffersAndSimDetailsControllerTest {

    @Mock
    private SimOffersService simOffersService;
    @Mock
    private SimDetailsService simDetailsService;
    @InjectMocks
    private SimDetailsController simDetailsController;
    @InjectMocks
    private SimOffersController simOffersController;

    private static final Long InvalidsimNumber = 12345L;
    private static final Long InvalidserviceNumber = 67890L;
    private static final Long validsimNumber = 1234567896L;
    private static final Long validserviceNumber = 678900L;

    @Test
    public void testValidateAndSendSimOffers() throws SimNotFoundException {
        //prepare Data
        SimOffers simOffers = new SimOffers();
        simOffers.setOfferName("Diwali bonus");
        simOffers.setOfferId(1);
        simOffers.setCost(500);

        //Mock data
        when(simDetailsService.validateAndSendSimOffers(validsimNumber,validserviceNumber)).thenReturn(simOffers);

        //Act
        ResponseEntity<?> response = simDetailsController.validateAndSendSimOffers(validsimNumber,validserviceNumber);

        //verify
        Assertions.assertNotNull(response);
        verify(simDetailsService,times(1)).validateAndSendSimOffers(validsimNumber,validserviceNumber);
    }

    @Test
    public void testInvalidSimNumberAndInvalidServiceNumberValidateAndSendSimOffers() throws SimNotFoundException {
        //Act
        ResponseEntity<?> response = simDetailsController.validateAndSendSimOffers(InvalidsimNumber, InvalidserviceNumber);

        // Assert
        ErrorResponse errorResponse = (ErrorResponse) response.getBody();
        Assertions.assertNotNull(errorResponse);
        Assertions.assertEquals("simNumber or serviceNumber does not meet length 10 or 6 respectively", errorResponse.getMessage());

        // Verify that the service method was never called
        verify(simDetailsService, never()).validateAndSendSimOffers(InvalidsimNumber, InvalidserviceNumber);
    }

    @Test
    public void testInsertSimOffers(){
        //prepare Data
        SimOffersDto simOffers = new SimOffersDto();
        simOffers.setOfferName("Diwali bonus");
        simOffers.setOfferId(1);
        simOffers.setCost(500);

        //Mock data
        when(simOffersService.insertSimOffers(simOffers)).thenReturn(simOffers);

        //Act
        ResponseEntity<?> response = simOffersController.insertSimOffers(simOffers);

        //Assert
        Assertions.assertNotNull(response.getBody());
        verify(simOffersService,times(1)).insertSimOffers(Mockito.any());
    }
}
