package com.example.companymanagementsystem.repository;

import com.example.companymanagementsystem.model.Company;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository {

    Company getById(Long id);

    List<Company> getAllCompanies();

    Company getByName(String name);

    Company create(Company company);

    Company update(Company company);

    void deleteById(Long id);

    void delete(Company company);
}
