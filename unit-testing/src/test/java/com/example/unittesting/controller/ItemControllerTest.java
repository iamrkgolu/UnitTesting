package com.example.unittesting.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.unittesting.business.ItemBusinessService;
import com.example.unittesting.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ItemBusinessService businessService;
	
	@Test
	public void item_basic() throws Exception {
		RequestBuilder request=MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result =mockMvc.perform(request)
								.andExpect(status().isOk())
								.andReturn();
//		assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", result.getResponse().getContentAsString());
		JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100,\"value\":0}", result.getResponse().getContentAsString(), true);
	}

	@Test
	public void itemFromBusinessService_basic() throws Exception {
		when(businessService.retreiveAllHardCodedValue()).thenReturn(
				new Item(1, "Ball", 100, 50));
		RequestBuilder request=MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
		MvcResult result =mockMvc.perform(request)
								.andExpect(status().isOk())
								.andReturn();
//		assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":50}", result.getResponse().getContentAsString());
		JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":50,\"value\":0}", result.getResponse().getContentAsString(), true);
	}
	
	@Test
	public void itemFromDataBase_basic() throws Exception {
		when(businessService.retreiveAllItem()).thenReturn(
				Arrays.asList(new Item(1, "Ball", 100, 50)));
		RequestBuilder request=MockMvcRequestBuilders.get("/item-from-database").accept(MediaType.APPLICATION_JSON);
		MvcResult result =mockMvc.perform(request)
								.andExpect(status().isOk())
								.andReturn();
		assertEquals("[{\"id\":1,\"name\":\"Ball\",\"price\":100,\"quantity\":50,\"value\":0}]"
			, result.getResponse().getContentAsString());
		
	}
}
