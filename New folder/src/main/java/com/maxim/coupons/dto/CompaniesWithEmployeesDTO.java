package com.maxim.coupons.dto;

import com.maxim.coupons.entities.Company;
import com.maxim.coupons.entities.Coupon;
import com.maxim.coupons.entities.User;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 4:37 PM
 */
public class CompaniesWithEmployeesDTO {
    private long id;
    private String name;
    private String telephoneNumber;
    private String address;
    private List<User> employees;
    private List<Coupon> coupons;


    public CompaniesWithEmployeesDTO(long id, String name, String telephoneNumber, String address, List<User> employees, List<Coupon> coupons) {
        this.id = id;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.employees = employees;
        this.coupons = coupons;
    }

    public CompaniesWithEmployeesDTO(String name, String telephoneNumber, String address, List<User> employees, List<Coupon> coupons) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.employees = employees;
        this.coupons = coupons;
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
