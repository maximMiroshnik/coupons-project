package com.maxim.coupons.controllers;

import com.maxim.coupons.dto.CompaniesDTO;
import com.maxim.coupons.entities.Company;
import com.maxim.coupons.logic.CompanyLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

/**
 * @author Maxim Myroshnyk
 * @date 3/1/2023 11:00 AM
 */
@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyLogic companyLogic;

    @Autowired
    public CompanyController(CompanyLogic companyLogic) {
        this.companyLogic = companyLogic;
    }

    @PostMapping
    public void createCompany(@RequestBody Company company) throws ServerException {
        companyLogic.createCompany(company);
    }

    @PutMapping
    public void updateCompany(@RequestBody Company company) throws ServerException {
        companyLogic.updateCompany(company);
    }

    @GetMapping
    public List<CompaniesDTO> getAllCompanies() {
        return companyLogic.getAllCompanies();
    }

    @GetMapping("/{companyId}")
    public CompaniesDTO getCompanyById(@PathVariable long companyId) {
        return companyLogic.getCompanyById(companyId);
    }

    @GetMapping("/name/{companyName}")
    public CompaniesDTO getCompanyByName(@PathVariable String companyName) {
        return companyLogic.getCompanyByName(companyName);
    }

    @DeleteMapping
    public void deleteAllCompanies() {
        companyLogic.deleteAllCompanies();
    }

    @DeleteMapping("/id/{companyId}")
    public void deleteCompanyById(@PathVariable long companyId) {
        companyLogic.deleteCompanyById(companyId);
    }

    @DeleteMapping("/name/{companyName}")
    public void deleteCompanyByName(@PathVariable String companyName) {
        companyLogic.deleteCompanyByName(companyName);
    }
}
