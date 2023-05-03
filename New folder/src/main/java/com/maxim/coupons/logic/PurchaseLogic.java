package com.maxim.coupons.logic;

import com.maxim.coupons.dal.IPurchaseDal;
import com.maxim.coupons.dto.PurchasesDTO;
import com.maxim.coupons.entities.Purchase;
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
public class PurchaseLogic {
    IPurchaseDal purchaseDal;

    @Autowired
    public PurchaseLogic(IPurchaseDal purchaseDal) {
        this.purchaseDal = purchaseDal;
    }

    public void createPurchase(Purchase purchase) throws ServerException {
       validatePurchase(purchase);
        purchaseDal.save(purchase);
    }


    public void updatePurchase(Purchase purchase) throws ServerException {
        validatePurchase(purchase);
        purchaseDal.save(purchase);

    }

    public List<PurchasesDTO> getAllPurchases() {
        return purchaseDal.getAllPurchases();
    }

    public PurchasesDTO getPurchaseById(long id) {
        return purchaseDal.getPurchaseById(id);
    }

    public void deleteAllPurchases() {
        purchaseDal.deleteAll();
    }

    public void deletePurchasesById(long id) {
        purchaseDal.deleteById(id);
    }

    public void validatePurchase(Purchase purchase) throws ServerException {
        if (purchase.getCoupon() == null) {
            throw new ServerException(ErrorType.COUPON_DOES_NOT_EXIST.getErrorMessage());
        }
        if (purchase.getCustomer() == null) {
            throw new ServerException(ErrorType.CUSTOMER_DOES_NOT_EXIST.getErrorMessage());
        }
        if (purchase.getAmount() <= 0) {
            throw new ServerException(ErrorType.INVALID_AMOUNT.getErrorMessage());
        }
    }
}
