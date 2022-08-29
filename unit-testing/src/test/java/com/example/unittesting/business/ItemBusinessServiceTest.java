package com.example.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.data.ItemRepository;
import com.example.unittesting.data.SomeDataService;
import com.example.unittesting.model.Item;

@ExtendWith(MockitoExtension.class)
public class ItemBusinessServiceTest {


	@InjectMocks
	private ItemBusinessService business;

	@Mock
	private ItemRepository repository;



	@Test
	public void calculateSumUsingDtaService_basic() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(1,"Bat",10,10),
						new Item(2,"Ball",15,15)));
		List<Item> items = business.retreiveAllItem();
		assertEquals(100, items.get(0).getValue());
		assertEquals(225, items.get(1).getValue());
	}

	

}
