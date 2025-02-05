package com.infosys.simactivationportal.entity;

import jakarta.persistence.*;

@Entity
public class SimDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long simId;
    private Long serviceNumber;
    private Long simNumber;
    private String simStatus;

    @OneToOne(mappedBy = "simDetails",cascade = CascadeType.ALL)
    private SimOffers simOffers;

    public SimDetails() {
    }

    public SimDetails(Long simId, Long serviceNumber, Long simNumber, String simStatus) {
        this.simId = simId;
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
        this.simStatus = simStatus;
    }

    public SimOffers getSimOffers() {
        return simOffers;
    }

    public void setSimOffers(SimOffers simOffers) {
        this.simOffers = simOffers;
    }

    public Long getSimId() {
        return simId;
    }

    public void setSimId(Long simId) {
        this.simId = simId;
    }

    public Long getServiceNumber() {
        return serviceNumber;
    }

    public void setServiceNumber(Long serviceNumber) {
        this.serviceNumber = serviceNumber;
    }

    public Long getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(Long simNumber) {
        this.simNumber = simNumber;
    }

    public String getSimStatus() {
        return simStatus;
    }

    public void setSimStatus(String simStatus) {
        this.simStatus = simStatus;
    }
}
