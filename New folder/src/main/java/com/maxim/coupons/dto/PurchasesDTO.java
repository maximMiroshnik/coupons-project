package com.maxim.coupons.dto;

import com.maxim.coupons.entities.Company;
import com.maxim.coupons.entities.Coupon;
import com.maxim.coupons.entities.Customer;
import com.maxim.coupons.entities.User;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:02 AM
 */
public class PurchasesDTO {
    private long id;
    private Customer customer;
    private Coupon coupon;

    public PurchasesDTO(long id, Customer customer, Coupon coupon) {
        this.id = id;
        this.customer = customer;
        this.coupon = coupon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }
}
