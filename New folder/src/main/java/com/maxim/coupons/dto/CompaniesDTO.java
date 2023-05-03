package com.maxim.coupons.dto;

import com.maxim.coupons.entities.Coupon;
import com.maxim.coupons.entities.User;

import javax.persistence.Column;
import java.util.Collection;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:02 AM
 */
public class CompaniesDTO {
    private long id;
    private String name;
    private String telephoneNumber;
    private String address;
    private List<User> employees;
    private List<Coupon> coupons;

    public CompaniesDTO(long id, String name, String telephoneNumber, String address, Collection<User> employees, Collection<Coupon> coupons) {
        this.id = id;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.employees = List.copyOf(employees);
        this.coupons = List.copyOf(coupons);
    }

    public CompaniesDTO(String name, String telephoneNumber, String address, Collection<User> employees, Collection<Coupon> coupons) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.employees = List.copyOf(employees);
        this.coupons = List.copyOf(coupons);
    }

    public CompaniesDTO(long id, String name, String telephoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public CompaniesDTO(String name, String telephoneNumber, String address) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

}
