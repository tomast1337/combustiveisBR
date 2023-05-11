package com.distribuidorabr.Service.interfaces;

import java.util.ArrayList;

import com.distribuidorabr.Model.Company;

public interface CompanyServiceIntf {

	public ArrayList<Company> findAll();
	public Company findById(int id);
	public Company findByCnpj(String cnpj);
	public Company findByCorporateName(String corporateName);
	public Company save(Company company);
	public Company update(Company company);
	public void delete(int id);
}
