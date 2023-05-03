package com.maxim.coupons.controllers;

import com.maxim.coupons.dto.PurchasesDTO;
import com.maxim.coupons.entities.Purchase;
import com.maxim.coupons.logic.PurchaseLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:00 AM
 */
@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    private PurchaseLogic purchaseLogic;

    @Autowired
    public PurchaseController(PurchaseLogic purchaseLogic) {
        this.purchaseLogic = purchaseLogic;
    }

    @PostMapping
    public void createPurchase(@RequestBody Purchase purchase) throws ServerException {
        purchaseLogic.createPurchase(purchase);
    }

    @PutMapping
    public void updatePurchase(@RequestBody Purchase purchase) throws ServerException {
        purchaseLogic.updatePurchase(purchase);
    }

    @GetMapping
    public List<PurchasesDTO> getAllPurchases(){
      return   purchaseLogic.getAllPurchases();
    }

    @GetMapping("{id}")
    public PurchasesDTO getPurchaseById(@PathVariable long id) {
        return purchaseLogic.getPurchaseById(id);
    }

    @DeleteMapping
    public void deleteAllPurchases(){
           purchaseLogic.deleteAllPurchases();
    }

    @DeleteMapping("{id}")
    public void deletePurchasesById(@PathVariable long id) {
         purchaseLogic.deletePurchasesById(id);
    }
}
