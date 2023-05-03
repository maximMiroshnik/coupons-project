package com.maxim.coupons.logic;

import com.maxim.coupons.dal.ICompanyDal;
import com.maxim.coupons.dto.CompaniesDTO;
import com.maxim.coupons.entities.Company;
import com.maxim.coupons.enums.ErrorType;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.serializer.support.SerializationFailedException;
import org.springframework.stereotype.Service;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:05 AM
 */
@Service
public class CompanyLogic {
    ICompanyDal iCompanyDal;

    @Autowired
    public CompanyLogic(ICompanyDal iCompanyDal) {
        this.iCompanyDal = iCompanyDal;
    }

    public long createCompany(Company company) throws ServerException {
        validateCompany(company);
        iCompanyDal.save(company);
        return company.getId();
    }


    public void updateCompany(Company company) throws ServerException {
        validateCompany(company);
        iCompanyDal.save(company);
    }

    public List<CompaniesDTO> getAllCompanies() {
        return iCompanyDal.getAllCompanies();
    }

    public CompaniesDTO getCompanyById(long companyId) {
        return iCompanyDal.getCompanyById(companyId);
    }

    public CompaniesDTO getCompanyByName(String companyName) {
        return iCompanyDal.getCompanyByName(companyName);
    }

    public void deleteAllCompanies() {
        iCompanyDal.deleteAll();
    }

    public void deleteCompanyById(long companyId) {
        iCompanyDal.deleteById(companyId);
    }

    public void deleteCompanyByName(String companyName) {
        iCompanyDal.deleteCompanyByName(companyName);
    }

    public void validateCompany(Company company) throws ServerException {
        if (company.getName().isEmpty()) {
            throw new ServerException(ErrorType.INVALID_NAME.getErrorMessage());
        }
        if (company.getName().length() < 3 || company.getName().length() > 45) {
            throw new ServerException(ErrorType.INVALID_NAME.getErrorMessage());

        }
        if (!company.getTelephoneNumber().contains("a-z")) {
            throw new ServerException(ErrorType.INVALID_PHONE_NUMBER.getErrorMessage());
        }
    }
}
