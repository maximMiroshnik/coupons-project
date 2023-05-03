package com.maxim.coupons.controllers;

import com.maxim.coupons.dto.CouponsDTO;
import com.maxim.coupons.entities.Coupon;
import com.maxim.coupons.exceptions.ServerException;
import com.maxim.coupons.logic.CouponLogic;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:00 AM
 */
@RestController
@RequestMapping("/coupons")
public class CouponController {

    private CouponLogic couponLogic;

    @Autowired
    public CouponController(CouponLogic couponLogic) {
        this.couponLogic = couponLogic;
    }

    @PostMapping
    public void createCoupon(@RequestBody Coupon coupon) throws java.rmi.ServerException {
        couponLogic.createCoupon(coupon);
    }

    @PutMapping
    public void updateCoupon(@RequestBody Coupon coupon) throws java.rmi.ServerException {
        couponLogic.updateCoupon(coupon);
    }

    @GetMapping
    public List<CouponsDTO> getAllCoupons(){
        return couponLogic.getAllCoupons();
    }

    @GetMapping("{id}")
    public CouponsDTO getCouponById(@PathVariable long couponId){
        return couponLogic.getCouponById(couponId);
    }

    @GetMapping("/name/{name}")
    public CouponsDTO getCouponByName(@PathVariable String name) throws ServerException {
        return couponLogic.getCouponByName(name);
    }

    @DeleteMapping("{couponId}")
    public void delete(@PathVariable long couponId) {
        couponLogic.deleteCoupon(couponId);
    }

    @DeleteMapping
    public void deleteAll() {
        couponLogic.deleteAllCoupons();
    }

}
