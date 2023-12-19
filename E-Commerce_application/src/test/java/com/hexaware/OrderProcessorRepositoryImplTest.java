package com.hexaware;

import static org.junit.Assert.*;


import com.hexaware.dao.OrderProcessorRepository;
import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Product;
import com.hexaware.exception.CustomerNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


/**
 * @author shailendra sharma
 * This is the test class to test methods in the OrderProcessorRepository
 */
public class OrderProcessorRepositoryImplTest {
	
	
	@Test
	public void testCreateProduct() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        
        Product product = new Product();
        product.setProductId(150);
        product.setName("TestProduct");
        product.setPrice(100);
        product.setDescription("Test Description");
        product.setStockQuantity(50);

		assertTrue(orderProcessorRepositoryImpl.createProduct(product));
	}
	
	@Test
	public void testCreateCustomer() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        Customer customer = new Customer();
        customer.setCustomerId(150);
        customer.setName("jake");
        customer.setEmail("jake@gmail.com");
        customer.setPassword("jake@123");
        
        assertTrue(orderProcessorRepositoryImpl.createCustomer(customer));
	}
	
	@Test
	public void testDeleteProduct() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        long productId = 150;
        assertTrue(orderProcessorRepositoryImpl.deleteProduct(productId));
	}
	
	@Test
	public void testDeleteCustomer() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        long customerId = 150;
        assertTrue(orderProcessorRepositoryImpl.deleteCustomer(customerId));
	}
	
	@Test 
	public void testAddToCart() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        long customerId = 152;
        long productId = 156;
        int quantity = 20;
        
        assertTrue(orderProcessorRepositoryImpl.addToCart(customerId, productId, quantity));
	}
	
	
	@Test
	public void testPlaceOrder() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        long customerId = 152;
        String shippingAddress = "Test Address";
        Map<Long, Integer> productsMap = new HashMap<>();
        productsMap.put((long) 156, 20);
        assertTrue(orderProcessorRepositoryImpl.placeOrder(customerId, productsMap, shippingAddress));
	}	
	
	@Test 
	public void testRemoveFromCart() {
        OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();
        long customerId = 152;
        long productId = 156;
        
        assertTrue(orderProcessorRepositoryImpl.removeFromCart(customerId, productId));
	}

}
