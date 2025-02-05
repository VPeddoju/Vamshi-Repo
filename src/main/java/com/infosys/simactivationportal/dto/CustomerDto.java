package com.infosys.simactivationportal.dto;

import com.infosys.simactivationportal.entity.Customer;
import com.infosys.simactivationportal.entity.CustomerAddress;
import com.infosys.simactivationportal.entity.SimDetails;

import java.time.LocalDate;

public class CustomerDto {

    private Long uniqueIdNumber;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastname;
    private String emailAddress;
    private String idType;
    private CustomerAddress customerAddress;
    private SimDetails simDetails;
    private String state;

    public CustomerDto() {
    }

    public CustomerDto(Long uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastname, String emailAddress, String idType, CustomerAddress customerAddress, SimDetails simDetails, String state) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
        this.idType = idType;
        this.customerAddress = customerAddress;
        this.simDetails = simDetails;
        this.state = state;
    }

    public Long getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public void setUniqueIdNumber(Long uniqueIdNumber) {
        this.uniqueIdNumber = uniqueIdNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public CustomerAddress getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(CustomerAddress customerAddress) {
        this.customerAddress = customerAddress;
    }

    public SimDetails getSimDetails() {
        return simDetails;
    }

    public void setSimDetails(SimDetails simDetails) {
        this.simDetails = simDetails;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer prepareEntityObject(CustomerDto dto) {
        Customer customer = new Customer();
        customer.setCustomerAddress(dto.getCustomerAddress());
        customer.setLastname(dto.getLastname());
        customer.setState(dto.getState());
        customer.setFirstName(dto.getFirstName());
        customer.setLastname(dto.getLastname());
        customer.setEmailAddress(dto.getEmailAddress());
        customer.setIdType(dto.getIdType());
        customer.setSimDetails(dto.getSimDetails());
        customer.setUniqueIdNumber(dto.getUniqueIdNumber());
        customer.setDateOfBirth(dto.getDateOfBirth());

        return customer;
    }
}
