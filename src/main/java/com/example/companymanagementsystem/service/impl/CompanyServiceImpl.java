package com.example.companymanagementsystem.service.impl;

import com.example.companymanagementsystem.model.Company;
import com.example.companymanagementsystem.repository.CompanyRepository;
import com.example.companymanagementsystem.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public Company getById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public Company getByName(String name) {
        return companyRepository.getByName(name);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    @Override
    public Company create(Company company) {
        return companyRepository.create(company);
    }

    @Override
    public Company update(Company company) {
        return companyRepository.update(company);
    }

    @Override
    public void deleteById(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    public void delete(Company company) {
        companyRepository.delete(company);
    }
}
