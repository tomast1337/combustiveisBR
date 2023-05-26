package com.distribuidorabr.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Order;

public interface OrderDAO extends JpaRepository<Order, UUID> {

}
