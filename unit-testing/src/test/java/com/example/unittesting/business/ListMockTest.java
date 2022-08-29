package com.example.unittesting.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ListMockTest {
	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void size_basic_return_multiple_value() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	@Test
	public void returnWithParameter() {
		when(mock.get(0)).thenReturn("Hi Rahul");
		assertEquals("Hi Rahul", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameter() {
		when(mock.get(anyInt())).thenReturn("Hi Rahul");
		assertEquals("Hi Rahul", mock.get(0));
		assertEquals("Hi Rahul", mock.get(1));
	}
	
	@Test
	public void verificationBasic() {
		String value=mock.get(0);
		String value1=mock.get(1);
		verify(mock).get(0);
		verify(mock,times(2)).get(anyInt());
		verify(mock,atLeast(1)).get(anyInt());
	}
	
	@Test
	public void argumentCapturing() {
		mock.add("Rahul");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		assertEquals("Rahul", captor.getValue());
	}
	@Test
	public void multipleArgumentCapturing() {
		mock.add("Rahul");
		mock.add("Kumar");
		ArgumentCaptor<String> captor=ArgumentCaptor.forClass(String.class);
		verify(mock,times(2)).add(captor.capture());
		List<String> value=captor.getAllValues();
		assertEquals("Rahul", value.get(0));
		assertEquals("Kumar", value.get(1));
	}
	
	@Test
	public void mocking() {
		ArrayList arrayListMock=mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		System.out.println(arrayListMock.add("test"));
		System.out.println(arrayListMock.add("test2"));
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
		
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy=spy(ArrayList.class);
		arrayListSpy.add("test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		System.out.println(arrayListSpy.add("test"));
		System.out.println(arrayListSpy.add("test2"));
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		
	}
}
