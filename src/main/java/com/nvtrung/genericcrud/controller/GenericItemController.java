package com.nvtrung.genericcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nvtrung.genericcrud.model.GenericItem;
import com.nvtrung.genericcrud.service.GenericItemService;

@Controller
public class GenericItemController {
	@Autowired
	private GenericItemService itemService;

	// display list of item
	@GetMapping("/")
	public String viewItemHomeList(Model model) {
		model.addAttribute("listItems", itemService.getAllItem());
		return "index";
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
	 public String deleteEmployee(@PathVariable(value = "id") long id) {
		 this.itemService.deleteItemById(id);
		 return "redirect:/";
	 }
}
