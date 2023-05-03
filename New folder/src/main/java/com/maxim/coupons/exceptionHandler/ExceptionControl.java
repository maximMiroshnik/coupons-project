//package com.maxim.coupons.exceptionHandler;
//
//import com.maxim.coupons.dto.ServerErrorData;
//import com.maxim.coupons.exceptions.ServerException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author Maxim Myroshnyk
// * @date 3/1/2023 11:04 AM
// */
//@RestControllerAdvice
//public class ExceptionControl {
//    @ExceptionHandler
//    @ResponseBody
//    public ServerErrorData exceptionResponse(HttpServletResponse httpServletResponse, Exception e) {
//        if (e instanceof ServerException) {
//            int errorCode = ((ServerException) e).getErrorType().getInternalErrorCode();
//            String errorMessage = ((ServerException) e).getErrorType().getErrorMessage();
//            String errorType = String.valueOf(((ServerException) e).getErrorType());
//
//            httpServletResponse.setStatus(errorCode);
//            if (((ServerException) e).getErrorType().isShowStackTrace()) {
//                e.printStackTrace();
//            }
//
//            return new ServerErrorData(errorCode, errorMessage, errorType);
//        }
//        httpServletResponse.setStatus(601);
//        return new ServerErrorData(601, "General Error", "Please contact your administrator");
//    }
//
//}
