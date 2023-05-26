package com.distribuidorabr.Model;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;

import com.distribuidorabr.enums.RoleName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Role implements GrantedAuthority, Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(columnDefinition = "BINARY(16)", updatable = false, nullable = false)
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = true)
	private RoleName roleName;
	
	public Role() {
		super();
	}
	public Role(RoleName roleName) {
		super();
		this.roleName = roleName;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public RoleName getRole() {
		return roleName;
	}
	public void setRole(RoleName roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String getAuthority() {
		return this.roleName.toString();
	}
	
	
}
