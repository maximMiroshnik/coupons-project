package com.maxim.coupons.dto;

import com.maxim.coupons.entities.User;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:03 AM
 */
public class CustomersDTO {

    private User user;
    private String phoneNumber;
    private String address;

    public CustomersDTO(User user, String phoneNumber, String address) {
        this.user = user;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
