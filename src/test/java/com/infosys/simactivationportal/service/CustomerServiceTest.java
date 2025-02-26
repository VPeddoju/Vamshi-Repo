package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.entity.Customer;
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

    private final static String email = "vammupeddoju@gmail.com";
    private final static String dob = "12-03-2000";

    @Test
    public void testInsertCustomer(){
        //prepare db entity
        Customer customer = new Customer();
        customer.setLastname("peddoju");
        customer.setState("telangana");
        customer.setEmailAddress("vammu@gmail.com");
        customer.setIdType("aadhar");

        //mock customerRepo
        when(customerRepository.save(Mockito.any())).thenReturn(customer);

        //calling actual methods
        Customer customerResponse = customerService.insertCustomer(new CustomerDto());

        //assert
        Assertions.assertNotNull(customerResponse);
        Assertions.assertEquals(customerResponse.getLastname(), customer.getLastname());
        verify(customerAddressRepository, times(1)).save(Mockito.any());
        verify(simDetailsRepository, times(1)).save(Mockito.any());
        verify(customerRepository, times(1)).save(Mockito.any());

    }

    @Test
    public void testvalidateCustomer(){
        //prepare db entity
        Customer customer = new Customer();
        customer.setState("telanagana");
        customer.setFirstName("vamshi");

        //mock customerRepo
        Mockito.when(customerRepository.findByEmailAddress(Mockito.any())).thenReturn(customer);

        //calling actual methods
        String str = customerService.validateCustomer(email,dob);

        //assert
        Assertions.assertNotNull(str);
        Mockito.verify(customerRepository, times(1)).findByEmailAddress(Mockito.any());
        Mockito.verify(customerAddressRepository, never()).save(Mockito.any());
    }
}
