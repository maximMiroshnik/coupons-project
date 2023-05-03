package com.maxim.coupons.dto;

import com.maxim.coupons.enums.UserType;

public class SuccessfulLoginData {
    private long id;
    private UserType userType;
    private long companyId;

    public SuccessfulLoginData() {
    }
    public SuccessfulLoginData(long id, UserType userType, Long companyId) {
        this.id = id;
        this.userType = userType;
        this.companyId = companyId;
    }

    public SuccessfulLoginData(long id) {
        this.id = id;
    }

    public SuccessfulLoginData(long id, UserType userType) {
        this.id = id;
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "SuccessfulLoginData{" +
                "id=" + id +
                ", userType='" + userType + '\'' +
                ", companyId='" + companyId + '\'' +
                '}';
    }
}