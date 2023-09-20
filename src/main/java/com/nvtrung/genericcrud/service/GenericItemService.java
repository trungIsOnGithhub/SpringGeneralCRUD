package com.nvtrung.genericcrud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nvtrung.genericcrud.model.GenericItem;

@Service
public interface GenericItemService {
	public List<GenericItem> getAllItem();
	public GenericItem getItemById(long id);
	public GenericItem addOneItem(GenericItem entity);
	public void deleteItemById(long id);
}