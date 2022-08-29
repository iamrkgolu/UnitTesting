package com.example.unittesting.business;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.unittesting.data.SomeDataService;

public class SomeBusinessStubTest {

	class SomeDataServiceStub implements SomeDataService {

		@Override
		public int[] retriveAllData() {
			return new int[] { 1, 2, 3 };
		}

	}

	class SomeDataServiceEmptyStub implements SomeDataService {

		@Override
		public int[] retriveAllData() {
			return new int[] {};
		}

	}

	class SomeDataServiceOneStub implements SomeDataService {
		int[] array = { 5 };

		@Override
		public int[] retriveAllData() {

			return array;
		}

		public int retriveData() {
			int[] array = { 5 };
			return array[array.length - 1];
		}

	}

	@Test
	public void calculateSumUsingDtaService_basic() {
		SomeBusinessImp business = new SomeBusinessImp();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingDtaService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDtaService_empty() {
		SomeBusinessImp business = new SomeBusinessImp();
		business.setSomeDataService(new SomeDataServiceEmptyStub());
		int actualResult = business.calculateSumUsingDtaService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDtaService_one() {
		SomeBusinessImp business = new SomeBusinessImp();
		business.setSomeDataService(new SomeDataServiceOneStub());
		int actualResult = business.calculateSumUsingDtaService();
		SomeDataServiceOneStub someDataServiceOneStub = new SomeDataServiceOneStub();
		int expectedResult = someDataServiceOneStub.retriveData();
		assertEquals(expectedResult, actualResult);
	}

}
