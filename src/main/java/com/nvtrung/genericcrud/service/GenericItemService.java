package com.nvtrung.genericcrud.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nvtrung.genericcrud.model.GenericItem;

@Service
public interface GenericItemService {
	public List<GenericItem> getAllItem();
	public GenericItem getItemById(long id);
	public GenericItem addOneItem(GenericItem entity);
	public void deleteItemById(long id);
	Page<GenericItem> getItemsPaginated(int pageNo, int pageSize);
	Page<GenericItem> getItemsPaginatedSorted(int pageNo, int pageSize, String sortField, String sortDirection);
}