package com.example.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class SomeBusinessTest {
	
	@Test
	public void calculateSum_basic() {
		SomeBusinessImp business=new SomeBusinessImp();
		int actualResult=business.calculateSum(new int[] {2,3,5,7,8});
		int expectedResult=25;
		assertEquals(expectedResult,actualResult);
	}

	
	@Test
	public void calculateSum_empty() {
		SomeBusinessImp business=new SomeBusinessImp();
		int actualResult=business.calculateSum(new int[] {});
		int expectedResult=0;
		assertEquals(expectedResult,actualResult);
	}

	@Test
	public void calculateSum_one() {
		SomeBusinessImp business=new SomeBusinessImp();
		int array[]= {1};
		int actualResult=business.calculateSum(array);
		int expectedResult=array[array.length-1];
		assertEquals(expectedResult,actualResult);
	}



}
