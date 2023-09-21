package com.nvtrung.genericcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
	
	@Override
	public GenericItem getItemById(long id) {
		Optional<GenericItem> optional = itemRepository.findById(id);
		
		GenericItem item = null;
	    if (optional.isPresent()) {
	    	item = optional.get();
	    } else {
	        throw new RuntimeException("Item not found for id :: " + id);
	    }

		return item;
	}
	
	@Override
	public GenericItem addOneItem(GenericItem entity) {
		Objects.requireNonNull(entity, "Null Data Detected Adding to Database!!");
		return this.itemRepository.save(entity);
	}
	
	@Override
	public void deleteItemById(long id) {
		this.itemRepository.deleteById(id);
	}
	
	@Override
	public Page<GenericItem> getItemsPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		return this.itemRepository.findAll(pageable);
	}
	
	@Override
	public Page<GenericItem> getItemsPaginatedSorted(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
		Sort.by(sortField).descending();
	 
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.itemRepository.findAll(pageable);
	}
}