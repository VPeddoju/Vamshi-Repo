package com.infosys.simactivationportal.service;

import com.infosys.simactivationportal.dto.CustomerAddressDto;
import com.infosys.simactivationportal.entity.CustomerAddress;
import com.infosys.simactivationportal.repository.CustomerAddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerAddressService {

    Logger logger = LoggerFactory.getLogger(CustomerAddressService.class);

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    public CustomerAddress updateCustomerAddress(CustomerAddressDto customerAddressDto) throws RuntimeException {

        Optional<CustomerAddress> optional = customerAddressRepository.findById(customerAddressDto.getAddressId());
        if (optional.isPresent()) {
            CustomerAddress customerAddress = optional.get();
            customerAddress.setAddress(customerAddressDto.getAddress());
            customerAddress.setCity(customerAddressDto.getCity());
            customerAddress.setPincode(customerAddressDto.getPincode());
            customerAddress.setState(customerAddressDto.getState());
            customerAddressRepository.save(customerAddress);

            return customerAddress;
        }
        else{
            throw new RuntimeException("customer not found");
        }
    }
}
