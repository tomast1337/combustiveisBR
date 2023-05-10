package com.distribuidorabr.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer> {

	Optional<Company> findByCnpj(String cnpj);

}
