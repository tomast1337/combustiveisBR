package com.distribuidorabr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Order;

public interface OrderDAO extends JpaRepository<Order, Integer> {

}
