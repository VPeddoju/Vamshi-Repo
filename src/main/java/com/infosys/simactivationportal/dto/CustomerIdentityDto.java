package com.infosys.simactivationportal.dto;

import com.infosys.simactivationportal.entity.CustomerIdentity;

import java.time.LocalDate;

public class CustomerIdentityDto {

    private Long uniqueIdNumber;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastname;
    private String emailAddress;
    private String state;

    public CustomerIdentityDto() {
    }

    public CustomerIdentityDto(Long uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastname, String emailAddress, String state) {
        this.uniqueIdNumber = uniqueIdNumber;
        this.dateOfBirth = dateOfBirth;
        this.firstName = firstName;
        this.lastname = lastname;
        this.emailAddress = emailAddress;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CustomerIdentityDto prepareDtoObject(CustomerIdentity customerIdentity){
        CustomerIdentityDto dto = new CustomerIdentityDto();

        dto.setLastname(customerIdentity.getLastname());
        dto.setState(customerIdentity.getState());
        dto.setFirstName(customerIdentity.getFirstName());
        dto.setEmailAddress(customerIdentity.getEmailAddress());
        dto.setUniqueIdNumber(customerIdentity.getUniqueIdNumber());
        dto.setDateOfBirth(customerIdentity.getDateOfBirth());

        return dto;
    }
}
