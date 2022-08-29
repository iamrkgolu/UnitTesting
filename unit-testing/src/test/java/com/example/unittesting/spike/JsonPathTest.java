package com.example.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		String responceFromService="[\n"
				+ "{\"id\":1,\"name\":\"Pencile\",\"quantity\":10},"
				+ "{\"id\":2,\"name\":\"Pen\",\"quantity\":10},"
				+ "{\"id\":3,\"name\":\"Notebook\",\"quantity\":10}"
				+ "]";
		
		DocumentContext context = JsonPath.parse(responceFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		List<Integer> ids=context.read("$..id");
		assertThat(ids).containsExactly(1,2,3);
		System.out.println(ids.toString());
		System.out.println(context.read("$.[1]").toString());
		System.out.println(context.read("$.[0:3]").toString());
		System.out.println(context.read("$.[?(@.name==='Pen')]").toString());
	}

}
