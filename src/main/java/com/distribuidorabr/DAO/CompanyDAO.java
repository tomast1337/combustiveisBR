package com.distribuidorabr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer> {

}
