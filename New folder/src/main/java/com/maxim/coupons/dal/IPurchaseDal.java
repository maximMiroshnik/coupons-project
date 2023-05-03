package com.maxim.coupons.dal;

import com.maxim.coupons.dto.PurchasesDTO;
import com.maxim.coupons.entities.Purchase;
import com.maxim.coupons.logic.PurchaseLogic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:02 AM
 */
public interface IPurchaseDal extends CrudRepository<Purchase, Long> {

    @Query("Select new com.maxim.coupons.dto.PurchasesDTO(p.id,p.customer,p.coupon) From Purchase p")
    List<PurchasesDTO> getAllPurchases();
    @Query("Select new com.maxim.coupons.dto.PurchasesDTO(p.id,p.customer,p.coupon) From Purchase p where p.id= :id")
    PurchasesDTO getPurchaseById(@Param("id") long id);
}
