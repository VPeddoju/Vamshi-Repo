package com.infosys.simactivationportal.entity;

import jakarta.persistence.*;

@Entity
public class SimOffers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer offerId;
    private Long callQty;
    private int cost;
    private int dataQty;
    private Long duration;
    private String offerName;
    @OneToOne
    @JoinColumn(name = "simId", nullable = false)
    private SimDetails simDetails;

    public SimOffers() {
    }

    public SimOffers(Integer offerId, Long callQty, int cost, int dataQty, Long duration, String offerName, SimDetails simDetails) {
        this.offerId = offerId;
        this.callQty = callQty;
        this.cost = cost;
        this.dataQty = dataQty;
        this.duration = duration;
        this.offerName = offerName;
        this.simDetails = simDetails;
    }

    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    public Long getCallQty() {
        return callQty;
    }

    public void setCallQty(Long callQty) {
        this.callQty = callQty;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDataQty() {
        return dataQty;
    }

    public void setDataQty(int dataQty) {
        this.dataQty = dataQty;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public SimDetails getSimDetails() {
        return simDetails;
    }

    public void setSimDetails(SimDetails simDetails) {
        this.simDetails = simDetails;
    }
}
