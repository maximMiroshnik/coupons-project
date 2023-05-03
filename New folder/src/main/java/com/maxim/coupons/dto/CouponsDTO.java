package com.maxim.coupons.dto;

import com.maxim.coupons.entities.Company;
import com.maxim.coupons.entities.Purchase;

import java.util.Date;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:03 AM
 */
public class CouponsDTO {
    private long id;
    private String name;
    private String category;
    private String description;
    private String companyName;
    private int price;
    private Date startDate;
    private Date endDate;
    private long amount;
    private Company company;
    private List<Purchase> purchases;

    public CouponsDTO(String name, String category, String description, String companyName, int price, Date startDate, Date endDate, long amount, Company company, List<Purchase> purchases) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.companyName = companyName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.company = company;
        this.purchases = purchases;
    }

    public CouponsDTO(String name, int price,String description, Date startDate, Date endDate,String companyName, String category) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.companyName = companyName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CouponsDTO(String name, int price, String description, Date startDate, Date endDate, String companyName) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.companyName = companyName;
    }


    public CouponsDTO(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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
