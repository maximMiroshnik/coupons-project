package com.maxim.coupons.exceptions;

import com.maxim.coupons.enums.ErrorType;

public class ServerException extends Exception {
    private final ErrorType errorType;

    public ServerException(ErrorType errorType) {
        super(errorType.getErrorMessage() + ": " + errorType.getInternalErrorCode());
        this.errorType = errorType;
        if (errorType.isShowStackTrace()) {
            printStackTrace();
        }
    }

    public ServerException(ErrorType errorType, String message) {
        super(message + ": " + errorType.getErrorMessage() + ": " + errorType.getInternalErrorCode());
        this.errorType = errorType;
        if (errorType.isShowStackTrace()) {
            printStackTrace();
        }
    }

    public ServerException(Exception e, ErrorType errorType) {
        super(e.getMessage() + ": " + errorType.getErrorMessage() + ": " + errorType.getInternalErrorCode(), e);
        this.errorType = errorType;
        if (errorType.isShowStackTrace()) {
            printStackTrace();
        }
    }

    public ServerException(Exception e, ErrorType errorType, String message) {
        super(e.getMessage() + ": " + message + ": " + errorType.getErrorMessage() + ": " + errorType.getInternalErrorCode(), e);
        this.errorType = errorType;
        if (errorType.isShowStackTrace()) {
            printStackTrace();
        }
    }

    public ErrorType getErrorType() {
        return errorType;
    }
}
