package com.maxim.coupons.dto;

/**
 * @author Maxim Myroshnyk
 * @date 22.02.2023 21:24
 */
public class ServerErrorData {
    private int errorCode;
    private String errorMessage;
    private String errorType;

    public ServerErrorData(int errorCode, String errorMessage, String errorType) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorType = errorType;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
