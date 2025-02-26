package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.Exceptions.SimNotFoundException;
import com.infosys.simactivationportal.dto.SimOffersDto;
import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.entity.SimOffers;
import com.infosys.simactivationportal.repository.SimDetailsRepository;
import com.infosys.simactivationportal.repository.SimOffersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SimOffersAndDetailsServiceTest {

    @Mock
    private SimOffersRepository simOffersRepository;
    @Mock
    private SimDetailsRepository simDetailsRepository;
    @InjectMocks
    private SimOffersService simOffersService;
    @InjectMocks
    private SimDetailsService simDetailsService;

    @Test
    public void testInsertSimOffers(){
        //prepare data
        SimDetails simDetails = new SimDetails();
        simDetails.setSimId(1L);
        simDetails.setSimNumber(9381122718L);

        SimOffersDto dto = new SimOffersDto();
        dto.setSimDetails(simDetails);

        //mock
        Mockito.when(simOffersRepository.save(Mockito.any())).thenReturn(new SimOffers());
        Mockito.when(simDetailsRepository.save(Mockito.any())).thenReturn(new SimDetails());

        //call actual method
        SimOffersDto simOffersDto = simOffersService.insertSimOffers(dto);

        //assert
        Assertions.assertNotNull(simOffersDto);
        verify(simOffersRepository, Mockito.times(1)).save(Mockito.any());
        verify(simDetailsRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void testInsertSimOffersThrowsRuntimeException(){
        // Arrange
        SimOffersDto simOffersDto = new SimOffersDto();
        simOffersDto.setSimDetails(null); // Simulate null SimDetails

        //assert and act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            simOffersService.insertSimOffers(simOffersDto);
        });

        // Verify the exception message
        assertEquals("provide sim details along with sim offers", exception.getMessage());

        // Verify that no repository methods were called
        verify(simOffersRepository, never()).save(Mockito.any());
        verify(simDetailsRepository, never()).save(Mockito.any());
    }

    @Test
    public void testValidateAndSendSimOffers() throws SimNotFoundException {
        //prepare data
        SimDetails simDetails = new SimDetails();
        simDetails.setSimNumber(9381122718L);
        SimOffers simOffers = new SimOffers();
        simOffers.setSimDetails(simDetails);
        simDetails.setSimOffers(simOffers);

        //Mock
        when(simDetailsRepository.findBySimNumberAndServiceNumber(Mockito.any(),Mockito.any())).thenReturn(simDetails);

        //call actual method
        SimOffers simOffersResponse = simDetailsService.validateAndSendSimOffers(Mockito.any(),Mockito.any());

        //assert
        Assertions.assertNotNull(simOffersResponse.getSimDetails());
        verify(simDetailsRepository,times(1)).findBySimNumberAndServiceNumber(Mockito.any(),Mockito.any());
    }

    @Test
    public void testValidateAndSendSimOffersThrowsSimNotFoundException(){
        // Arrange
        Long simNumber = 12345L;
        Long serviceNumber = 67890L;

        // Mock the repository to return null
        when(simDetailsRepository.findBySimNumberAndServiceNumber(simNumber, serviceNumber)).thenReturn(null);

        // Act & Assert
        SimNotFoundException exception = assertThrows(SimNotFoundException.class, () -> {
            simDetailsService.validateAndSendSimOffers(simNumber, serviceNumber);
        });

        // Verify the exception message
        assertEquals("sim not found with given sim number and service number", exception.getMessage());
        verify(simDetailsRepository, times(1)).findBySimNumberAndServiceNumber(simNumber, serviceNumber);
    }
}
