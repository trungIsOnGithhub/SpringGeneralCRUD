package com.nvtrung.genericcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nvtrung.genericcrud.service.GenericItemService;

@Controller
public class GenericItemController {
	@Autowired
	private GenericItemService itemService;

	// display list of item
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listItems", itemService.getAllItem());
		return "index";
	}
}
