package com.example.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.unittesting.data.SomeDataService;

@ExtendWith(MockitoExtension.class)

//@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

//	SomeBusinessImp business = new SomeBusinessImp();
//	SomeDataService dataServiceMock = mock(SomeDataService.class);

	@InjectMocks
	SomeBusinessImp business = new SomeBusinessImp();

	@Mock
	SomeDataService dataServiceMock;

//	@BeforeEach
//	public void before() {
//		business.setSomeDataService(dataServiceMock);
//	}

	@Test
	public void calculateSumUsingDtaService_basic() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 1, 2, 3 });

		int actualResult = business.calculateSumUsingDtaService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDtaServiceOne_basic() {

		when(dataServiceMock.retriveAllData()).thenReturn(new int[] { 1 });
		int actualResult = business.calculateSumUsingDtaService();
		int expectedResult = 1;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void calculateSumUsingDtaServiceEmpty_basic() {
		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {});
		int actualResult = business.calculateSumUsingDtaService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);
	}

}
