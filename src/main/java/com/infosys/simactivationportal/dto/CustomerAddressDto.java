package com.infosys.simactivationportal.dto;

import com.infosys.simactivationportal.entity.CustomerAddress;

public class CustomerAddressDto {
    private Integer addressId;
    private String city;
    private String address;
    private String state;
    private Long pincode;

    public CustomerAddressDto() {
    }

    public CustomerAddressDto(int addressId, String city, String address, String state, Long pincode) {
        this.addressId = addressId;
        this.city = city;
        this.address = address;
        this.state = state;
        this.pincode = pincode;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public CustomerAddress prepareEntityObject(CustomerAddressDto dto){
        CustomerAddress customerAddress = new CustomerAddress();

        customerAddress.setAddress(dto.getAddress());
        customerAddress.setAddressId(dto.getAddressId());
        customerAddress.setCity(dto.getCity());
        customerAddress.setPincode(dto.getPincode());
        customerAddress.setState(dto.getState());

        return customerAddress;
    }
}
