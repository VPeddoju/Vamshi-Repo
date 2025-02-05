package com.infosys.simactivationportal.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    private Long uniqueIdNumber;
    private LocalDate dateOfBirth;
    private String firstName;
    private String lastname;
    private String emailAddress;
    private String idType;
    @OneToOne
    @JoinColumn(name = "addressId", nullable = false)
    private CustomerAddress customerAddress;
    @OneToOne
    @JoinColumn(name = "simId", nullable = false)
    private SimDetails simDetails;
    private String state;

    public Customer() {
    }

    public Customer(Long uniqueIdNumber, LocalDate dateOfBirth, String firstName, String lastname, String emailAddress, String idType, CustomerAddress customerAddress, SimDetails simDetails, String state) {
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
}
