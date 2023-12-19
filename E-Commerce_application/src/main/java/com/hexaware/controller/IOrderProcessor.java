package com.hexaware.controller;

import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;

/**
 * @author shailendra sharma
 * This is the interface that will be implemented in the orderProcessorImpl class
 */
public interface IOrderProcessor {
	
	public void addProduct();
	
	public void addCustomer();
	
	public void removeProduct() throws ProductNotFoundException;
	
	public void removeCustomer() throws CustomerNotFoundException;
	
	public void addProductToCart() throws CustomerNotFoundException, ProductNotFoundException;
	
	public void removeProductFromCart() throws CustomerNotFoundException;
	
	public void getAllProductFromCart();
	
	public void addOrder() throws CustomerNotFoundException;
	
	public void getCustomerOrders();
}
