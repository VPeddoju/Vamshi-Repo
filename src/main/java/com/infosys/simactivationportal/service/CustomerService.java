package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.dto.CustomerDto;
import com.infosys.simactivationportal.entity.Customer;
import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.entity.SimOffers;
import com.infosys.simactivationportal.repository.CustomerAddressRepository;
import com.infosys.simactivationportal.repository.CustomerRepository;
import com.infosys.simactivationportal.repository.SimDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private SimDetailsRepository simDetailsRepository;

    public Customer insertCustomer(CustomerDto dto) {
        Customer customer = dto.prepareEntityObject(dto);
        customerAddressRepository.save(customer.getCustomerAddress());
        simDetailsRepository.save(customer.getSimDetails());
        return customerRepository.save(customer);
    }

    public String validateCustomer(String emailAddress, String dob){
        String[] date = dob.split("-");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
        Customer customer = customerRepository.findByEmailAddress(emailAddress);
        if(customer == null){
            return "customer not present";
        }
        return "customer is present";
    }
}
