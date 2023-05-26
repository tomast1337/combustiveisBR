package com.distribuidorabr.DAO;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.distribuidorabr.Model.Item;

public interface ItemDAO extends JpaRepository<Item, UUID> {

}
