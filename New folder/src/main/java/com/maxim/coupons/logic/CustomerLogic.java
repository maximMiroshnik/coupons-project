package com.maxim.coupons.logic;

import com.maxim.coupons.dal.ICustomerDal;
import com.maxim.coupons.dto.CustomersDTO;
import com.maxim.coupons.entities.Customer;
import com.maxim.coupons.enums.ErrorType;
import com.maxim.coupons.enums.UserType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:05 AM
 */
@Service
public class CustomerLogic {

    private ICustomerDal customerDal;
    private UserLogic userLogic;

    @Autowired
    public CustomerLogic(ICustomerDal customerDal, UserLogic userLogic) {
        this.customerDal = customerDal;
        this.userLogic = userLogic;
    }

    public long createCustomer(Customer customer) throws ServerException {
        customer.getUser().setUserType(UserType.CUSTOMER);
        validateCustomer(customer);
        customerDal.save(customer);
        return customer.getId();
    }


    public void updateCustomer(Customer customer) throws ServerException {
       validateCustomer(customer);
        customerDal.save(customer);

    }

    public List<CustomersDTO> getAllCustomers() {
        return customerDal.getAllCustomers();
    }

    public CustomersDTO getCustomerById(long id) {
        return customerDal.getCustomerById(id);
    }

    public void deleteAllCustomers() {
        customerDal.deleteAll();
    }

    public void deleteCustomerById(long id) {
        customerDal.deleteById(id);
    }

    public void validateCustomer(Customer customer)throws ServerException{
        userLogic.validateUser(customer.getUser());
        if(customer.getUser().getUserType() != UserType.CUSTOMER){
            throw new ServerException(ErrorType.CUSTOMER_DOES_NOT_EXIST.getErrorMessage());
        }
        if(customer.getAddress().length() < 5 || customer.getAddress().length() > 45){
            throw new ServerException(ErrorType.INVALID_ADDRESS.getErrorMessage());
        }
        if(customer.getPhoneNumber().length() < 5 || customer.getPhoneNumber().length() > 15){
            throw new ServerException(ErrorType.INVALID_PHONE_NUMBER.getErrorMessage());
        }
    }
}
