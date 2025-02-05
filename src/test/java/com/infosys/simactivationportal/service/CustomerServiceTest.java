package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.entity.Customer;
import com.infosys.simactivationportal.entity.CustomerAddress;
import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.repository.CustomerAddressRepository;
import com.infosys.simactivationportal.repository.CustomerRepository;
import com.infosys.simactivationportal.repository.SimDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private CustomerAddressRepository customerAddressRepository;
    @Mock
    private SimDetailsRepository simDetailsRepository;
    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testInsertCustomer(){
        CustomerDto dto = new CustomerDto();
        dto.setLastname("peddoju");
        dto.setState("telangana");
        dto.setEmailAddress("vammu@gmail.com");
        dto.setIdType("aadhar");

        Mockito.doNothing().when(customerAddressRepository).save(new CustomerAddress());
        Mockito.doNothing().when(customerRepository).save(new Customer());
        Mockito.doNothing().when(simDetailsRepository).save(new SimDetails());

        String str = customerService.insertCustomer(dto);

        Assertions.assertNotNull(str);

    }
}
