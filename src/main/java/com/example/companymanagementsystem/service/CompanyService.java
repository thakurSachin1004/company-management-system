package com.example.companymanagementsystem.service;

import com.example.companymanagementsystem.model.Company;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CompanyService {

    Company getById(Long id);

    Company getByName(String name);

    List<Company> getAllCompanies();

    Company create(Company company);

    Company update(Company company);

    void deleteById(Long id);

    void delete(Company company);

}
