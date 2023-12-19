package com.hexaware.controller;

import com.hexaware.dao.OrderProcessorRepository;
import com.hexaware.dao.OrderProcessorRepositoryImpl;
import com.hexaware.entity.Cart;
import com.hexaware.entity.Customer;
import com.hexaware.entity.Order;
import com.hexaware.entity.OrderItems;
import com.hexaware.entity.Product;
import com.hexaware.exception.CustomerNotFoundException;
import com.hexaware.exception.ProductNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/*
 * @author Shailendra Sharma.
*/
/*
 * This class implements IorderProcessor interface
 */
public class OrderProcessorImpl implements IOrderProcessor {
	
	OrderProcessorRepository orderProcessorRepositoryImpl = new OrderProcessorRepositoryImpl();

	Scanner scanner = new Scanner(System.in);
	
	Product product;
	Customer customer;
	
	/**
	 *This method is controller method to add product.
	 */
	@Override
	public void addProduct() {

		product = new Product();

		System.out.println("Enter product id: ");
		long productId = scanner.nextLong();
		scanner.nextLine();
		product.setProductId(productId);

		System.out.println("Enter product name: ");
		String productName = scanner.nextLine();
		product.setName(productName);

		System.out.println("Enter product price: ");
		int productPrice = scanner.nextInt();
		scanner.nextLine();
		product.setPrice(productPrice);

		System.out.println("Enter product description: ");
		String productDescription = scanner.nextLine();
		product.setDescription(productDescription);

		System.out.println("Enter product quantity");
		int stockQuantity = scanner.nextInt();
		scanner.nextLine();
		product.setStockQuantity(stockQuantity);

		if (orderProcessorRepositoryImpl.createProduct(product)) {
			System.out.println("Product has been added to the system!");
		} else {
			System.out.println("Error occured!!");
		}
	}

	/**
	 * This method is controller method to add customer.
	 */
	@Override
	public void addCustomer() {

		customer = new Customer();

		System.out.println("Enter customer id: ");
		long customerId = scanner.nextLong();
		scanner.nextLine();
		customer.setCustomerId(customerId);

		System.out.println("Enter customer name: ");
		String customerName = scanner.nextLine();
		customer.setName(customerName);

		System.out.println("Enter customer email: ");
		String customerEmail = scanner.nextLine();
		customer.setEmail(customerEmail);

		System.out.println("Enter customer password: ");
		String customerPassword = scanner.nextLine();
		customer.setPassword(customerPassword);

		if (orderProcessorRepositoryImpl.createCustomer(customer)) {
			System.out.println("Customer has been sucessfully added to the system");
		} else {
			System.out.println("Error occured!!");
		}
	}

	/**
	 *This method is controller method to remove product.
	 */
	@Override
	public void removeProduct() throws ProductNotFoundException {
		System.out.println("Enter product id to remove: ");
		long productId = scanner.nextLong();
		scanner.nextLine();
		if (orderProcessorRepositoryImpl.deleteProduct(productId)) {
			System.out.println("Producr deleted sucessfully");
		} else {
			throw new ProductNotFoundException();
		}
		
	}

	/**
	 *This method is controller method to remove customer.
	 */
	@Override
	public void removeCustomer() throws CustomerNotFoundException {
		System.out.println("Enter customer id to remove: ");
		long customerId = scanner.nextLong();
		scanner.nextLine();
		if (orderProcessorRepositoryImpl.deleteCustomer(customerId)) {
			System.out.println("Customer deleted sucessfully");
		} else {
			throw new CustomerNotFoundException();
		}
	}

	/**
	 *This method is used to add product to cart
	 */
	@Override
	public void addProductToCart() throws CustomerNotFoundException, ProductNotFoundException {

		System.out.println("Enter the customer id: ");
		long customerId = scanner.nextLong();
		scanner.nextLine();
		
		if (!orderProcessorRepositoryImpl.isCustomerExists(customerId)) {
			throw new CustomerNotFoundException();
		}
			
		System.out.println("Enter the id of product to be added: ");
		long productId = scanner.nextLong();
		scanner.nextLine();
		if (!orderProcessorRepositoryImpl.isProductExists(productId)) {
            throw new ProductNotFoundException();
        }

		System.out.println("Enter the quantity of product to be added: ");
		int quantity = scanner.nextInt();
		scanner.nextLine();

		if (orderProcessorRepositoryImpl.addToCart(customerId, productId, quantity)) {
			System.out.println("Product sucessfully added to cart");
		} else {
			System.out.println("Error occured!!");
		}
	}

	/**
	 *This method is used to remove product from cart
	 */
	@Override
	public void removeProductFromCart() throws CustomerNotFoundException {
		System.out.println("Enter the customer id: ");
		long customerId = scanner.nextLong();
		scanner.nextLine();
		
		if (!orderProcessorRepositoryImpl.isCustomerExists(customerId)) {
			throw new CustomerNotFoundException();
		}

		System.out.println("Enter the id of product to be deleted: ");
		long productId = scanner.nextLong();
		scanner.nextLine();

		if (orderProcessorRepositoryImpl.removeFromCart(customerId, productId)) {
			System.out.println("Product sucessfully removed from cart");
		} else {
			System.out.println("Error occured!!");
		}
	}

	/**
	 *This method is used to get all products from cart
	 */
	@Override
	public void getAllProductFromCart() {
		System.out.println("Enter customer id: ");
		long customerId = scanner.nextLong();

		List<List<Object>> result = orderProcessorRepositoryImpl.getAllFromCart(customerId);

		for (List<Object> product : result) {
			System.out.println("Product ID: " + product.get(0));
            System.out.println("Product Name: " + product.get(1));
            System.out.println("Total Quantity: " + product.get(2));
            System.out.println("--------------");
		}
	}

	/**
	 *@throws CustomerNotFoundException	 */
	/**
	 *The method is used to place order
	 */
	@Override
	public void addOrder() throws CustomerNotFoundException {
		System.out.println("Enter customer id: ");
		long customerId = scanner.nextLong();
		scanner.nextLine();
		
		if (!orderProcessorRepositoryImpl.isCustomerExists(customerId)) {
			throw new CustomerNotFoundException();
		}

		System.out.println("Enter shipping address: ");
		String shippingAddress = scanner.nextLine();

		List<List<Object>> productsInCart = orderProcessorRepositoryImpl.getAllFromCart(customerId);
		Map<Long, Integer> productsMap = new HashMap<>();

		for (List<Object> product : productsInCart) {
			long productId = (long) product.get(0);
			int totalQuantity = (Integer) product.get(2);
			productsMap.put(productId, totalQuantity);
		}

		System.out.println("Total price of the order is: " + orderProcessorRepositoryImpl.calculateTotalPrice(productsMap));

		if (orderProcessorRepositoryImpl.placeOrder(customerId, productsMap, shippingAddress)) {
			System.out.println("Order placed sucessfully");
		}
	}

	/**
	 *The method is used to get all orders for a customer
	 */
	@Override
	public void getCustomerOrders() {
		System.out.println("Enter customer id: ");
		long customerId = scanner.nextLong();
		
		List<List<Object>> ordersList = orderProcessorRepositoryImpl.getOrdersByCustomer(customerId);		
		for (List<Object> orderDetails : ordersList) {
			System.out.println("Order ID: " + orderDetails.get(0));
            System.out.println("Product ID: " + orderDetails.get(1));
            System.out.println("Product Name: " + orderDetails.get(2));
            System.out.println("Product Quantity: " + orderDetails.get(3));
            System.out.println("--------------");
            }
	}
}
