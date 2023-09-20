package com.nvtrung.genericcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nvtrung.genericcrud.model.GenericItem;

@Repository
public interface GenericItemRepository extends JpaRepository<GenericItem, Long> {}
