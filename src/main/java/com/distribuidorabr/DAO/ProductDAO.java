package com.distribuidorabr.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Product;

public interface ProductDAO extends JpaRepository<Product, UUID> {

}
