package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CNPJ;

import com.distribuidorabr.enums.BusinessRelationship;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="company")
public class Company extends Person implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(nullable=false, length = 100)
	@Size(min = 10, max = 200, message 
    = "Razão social deve conter entre 10 e 100 caracteres")
	private String corporateName;
	
	@Column(nullable=false, length = 18, unique=true)
	@Size(min = 14, max = 14, message 
    = "CNPJ deve conter 14 dígitos")
	@CNPJ(message="Escreva um CNPJ válido")
	@NotBlank(message="CNPJ é obrigatório")
	private String cnpj;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message="Campo obrigatório")
	private BusinessRelationship businessRelationship;
	
	public Company() {
		super();
	}

	public Company(String corporateName, String cnpj, BusinessRelationship businessRelationship) {
		super();
		this.corporateName = corporateName;
		this.cnpj = cnpj;
		this.businessRelationship = businessRelationship;
	}

	public String getCorporateName() {
		return corporateName;
	}

	public void setCorporateName(String corporateName) {
		this.corporateName = corporateName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public BusinessRelationship getBusinessRelationship() {
		return businessRelationship;
	}

	public void setBusinessRelationship(BusinessRelationship businessRelationship) {
		this.businessRelationship = businessRelationship;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cnpj);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}
	
}
