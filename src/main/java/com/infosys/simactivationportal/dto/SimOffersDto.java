package com.infosys.simactivationportal.dto;

import com.infosys.simactivationportal.entity.SimDetails;
import com.infosys.simactivationportal.entity.SimOffers;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class SimOffersDto {

    private Integer offerId;
    private Long callQty;
    private int cost;
    private int dataQty;
    private Long duration;
    private String offerName;
    private SimDetails simDetails;

    public SimOffersDto() {
    }

    public SimOffersDto(Integer offerId, Long callQty, int cost, int dataQty, Long duration, String offerName, SimDetails simDetails) {
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

    public SimOffersDto prepareDtoObject(SimOffers simOffers) {
        SimOffersDto dto = new SimOffersDto();

        dto.setCallQty(simOffers.getCallQty());
        dto.setCost(simOffers.getCost());
        dto.setOfferId(simOffers.getOfferId());
        dto.setOfferName(simOffers.getOfferName());
        dto.setDuration(simOffers.getDuration());
        dto.setSimDetails(simOffers.getSimDetails());
        dto.setDataQty(simOffers.getDataQty());

        return dto;
    }
}
