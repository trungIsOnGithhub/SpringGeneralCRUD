package com.nvtrung.genericcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nvtrung.genericcrud.model.GenericItem;
import com.nvtrung.genericcrud.service.GenericItemService;

@Controller
public class GenericItemController {
	@Autowired
	private GenericItemService itemService;

	// display list of item
	@GetMapping("/")
	public String viewItemHomeList(Model model) {
		return this.listItemPaginatedSorted(1, "firstName", "asc", model);
	}
	
	@GetMapping("/new")
	public String addNewItemForm(Model model) {
		GenericItem newItem = new GenericItem();
		model.addAttribute("newItem", newItem);
		return "new";
	}
	
	 @PostMapping("/new")
	 public String saveEmployee(@ModelAttribute("newItem") GenericItem newItem) {
	     // save employee to database
		 this.itemService.addOneItem(newItem);
	     return "redirect:/";
	 }
	 
	 @GetMapping("/update/{id}")
	 public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
		GenericItem item = itemService.getItemById(id);
		model.addAttribute("foundItem", item);
		return "update";
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String deleteItem(@PathVariable(value = "id") long id) {
		 this.itemService.deleteItemById(id);
		 return "redirect:/";
	 }
	 
//	 @GetMapping("/page/{pageNo}")
//	 public String listItemPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {		 
//	     int pageSize = 5;
//
//	     Page<GenericItem> page = itemService.getItemsPaginated(pageNo, pageSize);
//	     List<GenericItem> listEmployees = page.getContent();
//
//	     model.addAttribute("currentPage", pageNo);
//	     model.addAttribute("totalPages", page.getTotalPages());
//	     model.addAttribute("totalItems", page.getTotalElements());
//	     
//	     model.addAttribute("listItems", listEmployees);
//
//	     return "index";
//	 }
	 
	 @GetMapping("/page/{pageNo}")
	 public String listItemPaginatedSorted(@PathVariable(value = "pageNo") int pageNo,
			 @RequestParam("sortField") String sortField,
			 @RequestParam("sortDir") String sortDir,
			 Model model) {	 
	     int pageSize = 5;

	     Page<GenericItem> page = itemService.getItemsPaginated(pageNo, pageSize);
	     List<GenericItem> listEmployees = page.getContent();

	     model.addAttribute("currentPage", pageNo);
	     model.addAttribute("totalPages", page.getTotalPages());
	     model.addAttribute("totalItems", page.getTotalElements());
	     
	     model.addAttribute("sortField", sortField);
	     model.addAttribute("sortDir", sortDir);
	     model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
	     
	     model.addAttribute("listItems", listEmployees);

	     return "index";
	 }
}
