package com.example.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.model.Item;

@Component
public class ItemBusinessService {

	@Autowired
	private ItemRepository itemRepository;

	public Item retreiveAllHardCodedValue() {

		return new Item(1, "Bat", 100, 50);
	}

	public List<Item> retreiveAllItem() {
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;

	}

}
