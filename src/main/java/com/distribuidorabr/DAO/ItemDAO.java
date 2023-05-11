package com.distribuidorabr.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Item;

public interface ItemDAO extends JpaRepository<Item, Integer> {

}
