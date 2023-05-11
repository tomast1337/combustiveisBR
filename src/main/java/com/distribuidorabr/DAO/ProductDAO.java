package com.distribuidorabr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Product;

public interface ProductDAO extends JpaRepository<Product, Integer> {

}
