package com.maxim.coupons.entities;

import javax.persistence.*;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:03 AM
 */
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private User user;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    public Customer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
