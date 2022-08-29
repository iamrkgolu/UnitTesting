package com.example.unittesting.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ItemControllerIT {

	@Autowired
	private TestRestTemplate restTemplate;
	
	/*Used @MockBean
	 * Suppose if ur code is dependent on external library
	 * and u dont want to connect or include in ur testing
	 * then simply annotate this with @MockBean
	 * */
	
	
	@Test
	public void contextLoad() throws JSONException {
		String response = this.restTemplate.getForObject("/item-from-database", String.class);
		JSONAssert.assertEquals("[{id:10001},{id:10002},{id:10003}]", response, false);
	}
	
}
