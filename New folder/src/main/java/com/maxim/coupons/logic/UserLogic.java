package com.maxim.coupons.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.maxim.coupons.dal.IUserDal;
import com.maxim.coupons.dto.SuccessfulLoginData;
import com.maxim.coupons.dto.UserLoginData;
import com.maxim.coupons.dto.UsersDTO;
import com.maxim.coupons.entities.User;
import com.maxim.coupons.enums.ErrorType;
import com.maxim.coupons.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:05 AM
 */
@Service
public class UserLogic {
    private IUserDal userDal;
    private CompanyLogic companyLogic;

    @Autowired
    public UserLogic(IUserDal userDal, CompanyLogic companyLogic) {
        this.userDal = userDal;
        this.companyLogic = companyLogic;
    }

    public long createUser(User user) throws ServerException {
        validateUser(user);
        userDal.save(user);
        return user.getId();
    }

    public void updateUser(User user) throws ServerException {
        validateUser(user);
        userDal.save(user);
    }
    public List<UsersDTO> getAllUsers() {
        return userDal.getAllUsers();
    }

    public UsersDTO getUserById(long id) {
        return userDal.getUserById(id);
    }

    public UsersDTO getUserByName(String name) {
        return userDal.getUserByName(name);
    }

    public void deleteAllUsers() {
        userDal.deleteAll();
    }

    public void deleteUserById(long id) {
        userDal.deleteById(id);
    }

    public String login(UserLoginData userDetails) throws ServerException, JsonProcessingException {
        SuccessfulLoginData user = userDal.login(userDetails.getUserName(), userDetails.getPassword());
        if (user == null) {
            throw new ServerException(ErrorType.LOGIN_FAILURE.getErrorMessage());
        }
        String token = JWTUtils.createJWT(user);
        return token;

    }

    public void validateUser(User user) throws ServerException {
        if (user.getUserName().length() < 5 || user.getUserName().length() > 45) {
            throw new ServerException(ErrorType.INVALID_NAME.getErrorMessage());
        }
        if (user.getPassword().length() < 5 || user.getPassword().length() > 45) {
            throw new ServerException(ErrorType.INVALID_PASSWORD.getErrorMessage());
        }
        if (user.getCompany() != null) {
            if (companyLogic.getCompanyById(user.getCompany().getId()) == null) {
                throw new ServerException(ErrorType.COMPANY_DOES_NOT_EXIST.getErrorMessage());
            }
        }
    }
}
