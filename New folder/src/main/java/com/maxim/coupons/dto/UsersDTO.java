package com.maxim.coupons.dto;

import com.maxim.coupons.entities.Company;
import com.maxim.coupons.entities.Purchase;
import com.maxim.coupons.enums.UserType;

import java.util.Collection;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:02 AM
 */
public class UsersDTO {
    private long id;
    private String name;
    private String password;
    private int age;
    private UserType userType;
    private Company company;
    private List<Purchase> purchases;

    public UsersDTO(long id, String name, String password, int age, UserType userType, Company company, List<Purchase> purchases) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.userType = userType;
        this.company = company;
        this.purchases = purchases;
    }


    public UsersDTO(String name, String password, int age, UserType userType, String companyName) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.userType = userType;
        this.company = new Company();
        this.company.setName(companyName);
    }



    public UsersDTO(long id, String password, String name, UserType userType, String companyName) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.company = new Company();
        this.company.setName(companyName);
    }

    public UsersDTO(String password, String name, UserType userType, String companyName) {
        this.password = password;
        this.name = name;
        this.userType = userType;
        this.company = new Company();
        this.company.setName(companyName);
    }

    public UsersDTO(String name, UserType userType, String companyName) {
        this.name = name;
        this.userType = userType;
        this.company = new Company();
        this.company.setName(companyName);
    }

    public UsersDTO(long id, String name, String password, int age, UserType userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.userType = userType;
    }

    public UsersDTO(String name, String password, int age, UserType userType, Company company, Collection<Purchase> purchases) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.userType = userType;
        this.company = company;
        this.purchases = (List<Purchase>) purchases;
    }

    public UsersDTO(String name, int age, UserType userType) {
        this.name = name;
        this.age = age;
        this.userType = userType;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
