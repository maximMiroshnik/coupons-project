package com.maxim.coupons.dal;

import com.maxim.coupons.dto.CouponsDTO;
import com.maxim.coupons.entities.Coupon;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:01 AM
 */
public interface ICouponDal extends CrudRepository<Coupon, Long> {
    @Query("Select new com.maxim.coupons.dto.CouponsDTO(coup.name, coup.price, coup.description, coup.startDate, coup.endDate, comp.name, coup.category) " +
    " From Coupon coup join Company comp on coup.company.id = comp.id")
    List<CouponsDTO> getAllCoupons();


    @Query("Select new com.maxim.coupons.dto.CouponsDTO(coup.name, coup.price, coup.description, coup.startDate, coup.endDate, comp.name) " +
            " From Coupon coup join Company comp on coup.company.id = comp.id where coup.id= :id")
    CouponsDTO getCouponById(@Param("id") long couponId);

    @Query("Select new com.maxim.coupons.dto.CouponsDTO(c.id,c.name,c.description) from Coupon c where c.name= :name")
    CouponsDTO getCouponByName(@Param("name") String name);
}
