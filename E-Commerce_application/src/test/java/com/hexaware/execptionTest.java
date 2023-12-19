package com.hexaware;

import static org.junit.Assert.*;


import org.junit.Test;
import com.hexaware.exception.ProductNotFoundException;
import com.hexaware.controller.OrderProcessorImpl;


public class execptionTest {
	
	@Test (expected = ProductNotFoundException.class)
	public void testException() throws ProductNotFoundException{
		OrderProcessorImpl orderProcessorImpl = new OrderProcessorImpl();
		orderProcessorImpl.removeProduct();
		
	}
}
