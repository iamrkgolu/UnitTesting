package com.example.unittesting.spike;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AssertJTest {
	@Test
	public void learning() {
		List<Integer> numbers=Arrays.asList(12,14,16);
		assertThat(numbers).hasSize(3).contains(12,16);
		
	}

}
