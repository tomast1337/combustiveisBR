package com.distribuidorabr.Service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.distribuidorabr.DAO.CompanyDAO;
import com.distribuidorabr.Model.Company;
import com.distribuidorabr.Service.interfaces.CompanyServiceIntf;

@Service
public class CompanyService implements CompanyServiceIntf{

	@Autowired
	private CompanyDAO dao;
	
	@Override
	public ArrayList<Company> findAll() {
		return (ArrayList<Company>)dao.findAll();
	}

	@Override
	public Company findById(UUID id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Company findByCnpj(String cnpj) {
		return dao.findByCnpj(cnpj).orElse(null);
	}

	@Override
	public Company findByCorporateName(String corporateName) {
		return dao.findByCorporateNameContaining(corporateName).orElse(null);
	}
	
	@Override
	public Company save(Company employee) {
		return dao.save(employee);
	}

	@Override
	public Company update(Company employee) {
		
		if(employee.getId() != null && employee.getCorporateName() != null) {
			return dao.save(employee);
		} else {
			return null;
		}
		
	}

	@Override
	public void delete(UUID id) {
		dao.deleteById(id);
	}

}
