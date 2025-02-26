package com.infosys.simactivationportal.controller;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.entity.Customer;
import com.infosys.simactivationportal.service.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    private final static String email = "vammupeddoju@gmail.com";
    private final static String dob = "12-03-2000";
    private final static String string = "successfully inserted";

    @Test
    public void testInsertCustomerDetails(){

        Customer customer = new Customer();
        customer.setFirstName("Vamshi");
        customer.setState("Telangana");
        customer.setLastname("Peddoju");
        //Mock
        Mockito.when(customerService.insertCustomer(Mockito.any())).thenReturn(customer);

        //calling actual methods
        ResponseEntity<?> response = customerController.insertCustomerDetails(Mockito.any());

        //assert
        Assertions.assertNotNull(response);
        Assertions.assertEquals(string, Objects.requireNonNull(response.getBody()).toString());
        Mockito.verify(customerService,Mockito.times(1)).insertCustomer(Mockito.any());
    }
}
