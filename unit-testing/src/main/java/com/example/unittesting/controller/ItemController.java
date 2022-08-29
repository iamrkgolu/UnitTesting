package com.example.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.unittesting.business.ItemBusinessService;
import com.example.unittesting.model.Item;

@RestController
public class ItemController {
	
	@Autowired
	ItemBusinessService businessService;
	
	@GetMapping(value = "/dummy-item")
	public Item item() {
		return new Item(1,"Ball",10,100);
	}

	@GetMapping(value = "/item-from-business-service")
	public Item itemFromBusinessService() {
		return businessService.retreiveAllHardCodedValue();
	}
	
	@GetMapping(value = "/item-from-database")
	public List<Item> itemFromDataBase() {
		return businessService.retreiveAllItem();
	}
}
