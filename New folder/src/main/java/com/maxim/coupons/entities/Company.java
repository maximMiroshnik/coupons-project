package com.maxim.coupons.entities;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:03 AM
 */
@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<User> employees;

    @OneToMany(mappedBy = "company", cascade = CascadeType.REMOVE)
    private List<Coupon> coupons;

    public Company() {
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

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<User> getEmployees() {
        return employees;
    }

    public void setEmployees(List<User> employees) {
        this.employees = employees;
    }


}
