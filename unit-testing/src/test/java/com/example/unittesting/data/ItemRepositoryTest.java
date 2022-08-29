package com.example.unittesting.data;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.unittesting.model.Item;

@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository repository;
	
	@Test
	public void findAll() {
		List<Item> items = repository.findAll();
		assertEquals(3,items.size());
	}
	

}
