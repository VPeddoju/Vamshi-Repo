package com.infosys.simactivationportal.dto;

import com.infosys.simactivationportal.entity.SimDetails;

public class SimDetailsDto {

    private Long simId;
    private Long serviceNumber;
    private Long simNumber;
    private String simStatus;

    public SimDetailsDto() {
    }

    public SimDetailsDto(Long simId, Long serviceNumber, Long simNumber, String simStatus) {
        this.simId = simId;
        this.serviceNumber = serviceNumber;
        this.simNumber = simNumber;
        this.simStatus = simStatus;
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

    public SimDetailsDto prepareDtoObject(SimDetails simDetails) {
        SimDetailsDto dto = new SimDetailsDto();

        dto.setSimId(simDetails.getSimId());
        dto.setSimNumber(simDetails.getSimNumber());
        dto.setSimStatus(simDetails.getSimStatus());
        dto.setServiceNumber(simDetails.getServiceNumber());

        return dto;
    }
}
