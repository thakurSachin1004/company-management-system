package com.example.companymanagementsystem.repository.impl;

import com.example.companymanagementsystem.model.*;
import com.example.companymanagementsystem.repository.CompanyRepository;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Company getById(Long id) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);

        Root<Company> root = cq.from(Company.class);
        root.fetch(Company_.cars, JoinType.LEFT);

        Fetch<Company, Department> departmentFetch = root.fetch(Company_.departments, JoinType.LEFT);
        Fetch<Department, Employee> employeeFetch = departmentFetch.fetch(Department_.employees, JoinType.LEFT);

        departmentFetch.fetch(Department_.offices, JoinType.LEFT);
        employeeFetch.fetch(Employee_.address, JoinType.LEFT);

        cq.select(root).distinct(true);
        Predicate idPredicate = cb.equal(root.get(Company_.id), id);

        cq.where(cb.and(idPredicate));
        return DataAccessUtils.singleResult(em.createQuery(cq).getResultList());
    }

    @Override
    public List<Company> getAllCompanies() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);
        Root<Company> root = cq.from(Company.class);
        cq.select(root).distinct(true);
        TypedQuery<Company> tq = em.createQuery(cq);
        return tq.getResultList();
    }

    @Override
    public Company getByName(String name) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Company> cq = cb.createQuery(Company.class);

        Root<Company> root = cq.from(Company.class);
        root.fetch(Company_.cars, JoinType.LEFT);
        Fetch<Company,Department> departmentFetch = root.fetch(Company_.departments, JoinType.LEFT);
        Fetch<Department, Employee> employeeFetch = departmentFetch.fetch(Department_.employees, JoinType.LEFT);

        departmentFetch.fetch(Department_.offices, JoinType.LEFT);
        employeeFetch.fetch(Employee_.address, JoinType.LEFT);

        cq.select(root).distinct(true);
        Predicate namePredicate = cb.equal(root.get(Company_.name), name);
        cq.where(cb.and(namePredicate));
        return DataAccessUtils.singleResult(em.createQuery(cq).getResultList());
    }

    @Override
    public Company create(Company company) {
        em.persist(company);
        return null;
    }

    @Override
    public Company update(Company company) {
        return em.merge(company);
    }

    @Override
    public void deleteById(Long id) {
        Company company = em.find(Company.class, id);
        delete(company);
    }

    @Override
    public void delete(Company company) {
        em.remove(company);
    }
}
