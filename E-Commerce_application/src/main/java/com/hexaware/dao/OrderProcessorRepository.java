package com.hexaware.dao;

import com.hexaware.entity.*;
import java.util.List;
import java.util.Map;

/**
 * @author Shailendra sharma
 * This interface has all function required for database functionality
 */
public interface OrderProcessorRepository {
	
	public boolean createProduct(Product product);
	
	public boolean createCustomer(Customer customer);
	
	public boolean deleteProduct(long productId);
	
	public boolean deleteCustomer(long customerId);
	
	public boolean addToCart(long customerId, long productId, int quantity);
	
	public boolean removeFromCart(long customerId, long productId);
	
	public List getAllFromCart(long customerId);
	
	public List getOrdersByCustomer(long customerId);

	public boolean placeOrder(long customerId, Map<Long, Integer> productsMap, String shippingAddress);

	public int calculateTotalPrice(Map<Long, Integer> productsMap);

	public boolean isProductExists(long productId);

	public boolean isCustomerExists(long customerId);
}
