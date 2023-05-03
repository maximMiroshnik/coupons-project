package com.maxim.coupons.dal;

import com.maxim.coupons.dto.CustomersDTO;
import com.maxim.coupons.entities.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:01 AM
 */
public interface ICustomerDal extends CrudRepository<Customer, Long> {
    @Query("Select new com.maxim.coupons.dto.CustomersDTO(c.user, c.address, c.phoneNumber) From Customer c")
    List<CustomersDTO> getAllCustomers();

    @Query("Select new com.maxim.coupons.dto.CustomersDTO(c.user, c.address, c.phoneNumber) From Customer c where c.id= :id")
    CustomersDTO getCustomerById(@Param("id") long id);
}
