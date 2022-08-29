package com.example.unittesting.business;

import com.example.unittesting.data.SomeDataService;

public class SomeBusinessImp {
	
	private SomeDataService someDataService;
	
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}

	public int calculateSum(int[] data) {
		int sum=0;
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}

	public int calculateSumUsingDtaService() {
		int sum=0;
		int [] data=someDataService.retriveAllData();
		for(int value:data) {
			sum+=value;
		}
		return sum;
	}
}
