package com.nvtrung.genericcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.nvtrung.genericcrud.model.GenericItem;
import com.nvtrung.genericcrud.repository.GenericItemRepository;

@Service
public class GenericItemServiceImpl implements GenericItemService {
	@Autowired
	private GenericItemRepository itemRepository;
	
	@Override
	public List<GenericItem> getAllItem() {
		return itemRepository.findAll();
	}
}