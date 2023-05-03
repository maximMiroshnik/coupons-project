package com.maxim.coupons.dal;

import com.maxim.coupons.dto.SuccessfulLoginData;
import com.maxim.coupons.dto.UsersDTO;
import com.maxim.coupons.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:01 AM
 */
public interface IUserDal extends CrudRepository<User, Long> {
    @Query("Select new com.maxim.coupons.dto.UsersDTO(u.userName, u.password, u.age, u.userType, c.name) from User u  join Company c " +
            "On c.id=u.company.id")
    List<UsersDTO> getAllUsers();

    @Query("Select new com.maxim.coupons.dto.UsersDTO(u.id, u.password, u.userName, u.age, u.userType) from User u Join Company c " +
            "On c.id=u.company.id where u.id= :id")
    UsersDTO getUserById(@Param("id") long id);

    @Query("Select new com.maxim.coupons.dto.UsersDTO(u.userName, u.age, u.userType) from User u where u.userName= :userName")
    UsersDTO getUserByName(@Param("userName") String userName);

    @Query("Select new com.maxim.coupons.dto.UsersDTO(u.id, u.password, u.userName, u.age, u.userType)From User u Join Company c " +
    "On u.company.id=c.id where c.name= :companyName")
    List<UsersDTO> findAllUsersByCompanyName(@Param("companyName") String companyName);

    @Query("SELECT new com.maxim.coupons.dto.SuccessfulLoginData(u.id) " +
            "FROM User u where u.userName= :userName and u.password= :password")
    SuccessfulLoginData login(@Param("userName") String userName, @Param("password") String password);
}
