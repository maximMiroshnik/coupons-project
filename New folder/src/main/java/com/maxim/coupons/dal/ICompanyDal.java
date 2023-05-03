package com.maxim.coupons.dal;

import com.maxim.coupons.dto.CompaniesDTO;
import com.maxim.coupons.entities.Company;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:01 AM
 */
public interface ICompanyDal extends CrudRepository<Company, Long> {

    @Query("SELECT NEW com.maxim.coupons.dto.CompaniesDTO(c.id, c.name, c.telephoneNumber, c.address) FROM Company c")
    List<CompaniesDTO> getAllCompanies();

    @Query("SELECT NEW com.maxim.coupons.dto.CompaniesDTO(c.id, c.name, c.telephoneNumber, c.address) FROM Company c Where c.id= :companyId")
    CompaniesDTO getCompanyById(@Param("companyId") long id);

    @Query("SELECT NEW com.maxim.coupons.dto.CompaniesDTO(c.id, c.name, c.telephoneNumber, c.address) FROM Company c Where c.name= :companyName")
    CompaniesDTO getCompanyByName(@Param("companyName") String companyName);

    @Modifying
    @Query("DELETE FROM Company c WHERE c.name = :companyName")
    void deleteCompanyByName(@Param("companyName") String companyName);
}
