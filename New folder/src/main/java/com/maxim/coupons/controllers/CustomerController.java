package com.maxim.coupons.controllers;

import com.maxim.coupons.dto.CustomersDTO;
import com.maxim.coupons.entities.Customer;
import com.maxim.coupons.enums.UserType;
import com.maxim.coupons.logic.CustomerLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:00 AM
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerLogic customerLogic;

    @Autowired
    public  CustomerController(CustomerLogic customerLogic){
        this.customerLogic= customerLogic;
    }


    @PostMapping
    public void createCustomer(@RequestBody Customer customer) throws ServerException {
        customerLogic.createCustomer(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer) throws ServerException {
        customerLogic.updateCustomer(customer);
    }

    @GetMapping
    public List<CustomersDTO> getAllCustomers(){
       return customerLogic.getAllCustomers();
    }

    @GetMapping("{id}")
    public CustomersDTO getCustomerById(@PathVariable long id){
       return  customerLogic.getCustomerById(id);
    }

    @DeleteMapping
    public void deleteAllCustomers(){
        customerLogic.deleteAllCustomers();
    }

    @DeleteMapping("{id}")
    public void deleteCustomerByID(@PathVariable long id){
        customerLogic.deleteCustomerById(id);
    }
}
