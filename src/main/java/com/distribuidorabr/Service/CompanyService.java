package com.distribuidorabr.Service;

import java.util.ArrayList;

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
	public Company findById(int id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public Company findByCnpj(String cnpj) {
		return dao.findByCnpj(cnpj).orElse(null);
	}

	@Override
	public Company findByCorporateName(String corporateName) {
		return dao.findByCnpj(corporateName).orElse(null);
	}
	
	@Override
	public Company save(Company employee) {
		return dao.save(employee);
	}

	@Override
	public Company update(Company employee) {
		
		if(employee.getId() != 0 && employee.getCorporateName() != null) {
			return dao.save(employee);
		} else {
			return null;
		}
		
	}

	@Override
	public void delete(int id) {
		dao.deleteById(id);
	}

}
