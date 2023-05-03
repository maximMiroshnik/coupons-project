package com.maxim.coupons.logic;

import com.maxim.coupons.dal.ICouponDal;
import com.maxim.coupons.dto.CouponsDTO;
import com.maxim.coupons.entities.Coupon;
import com.maxim.coupons.enums.ErrorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:05 AM
 */
@Service
public class CouponLogic {

    private ICouponDal couponDal;
    private CompanyLogic companyLogic;

    @Autowired
    public CouponLogic(ICouponDal couponDal, CompanyLogic companyLogic) {
        this.couponDal = couponDal;
        this.companyLogic = companyLogic;
    }

    public long createCoupon(Coupon coupon) throws ServerException {
        validateCoupon(coupon);
        couponDal.save(coupon);
        return coupon.getId();
    }

    public void updateCoupon(Coupon coupon) throws ServerException {
        validateCoupon(coupon);
        couponDal.save(coupon);
    }

    public List<CouponsDTO> getAllCoupons() {
        return couponDal.getAllCoupons();
    }

    public CouponsDTO getCouponById(long couponId) {
        return couponDal.getCouponById(couponId);
    }

    public CouponsDTO getCouponByName(String name) {
        return couponDal.getCouponByName(name);
    }

    public void deleteCoupon(long couponId) {
        couponDal.deleteById(couponId);
    }

    public void deleteAllCoupons() {
        couponDal.deleteAll();
    }

    public void validateCoupon(Coupon coupon) throws ServerException{
        if (coupon.getAmount() <= 0) {
            throw new ServerException(ErrorType.INVALID_AMOUNT.getErrorMessage());
        }
        if (coupon.getName().isEmpty() || coupon.getName().length() < 2) {
            throw new ServerException(ErrorType.INVALID_NAME.getErrorMessage());
        }
        if (coupon.getPrice() <= 0) {
            throw new ServerException(ErrorType.INVALID_PRICE.getErrorMessage());
        }
        if (companyLogic.getCompanyById(coupon.getCompany().getId()) == null) {
            throw new ServerException(ErrorType.COMPANY_DOES_NOT_EXIST.getErrorMessage());
        }
    }
}
