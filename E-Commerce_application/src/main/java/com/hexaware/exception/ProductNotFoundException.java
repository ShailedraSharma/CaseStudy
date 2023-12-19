package com.hexaware.exception;

/**
 * @author Shailendra Sharma
 * This class has the exception for scenario when Product is not found in system
 */
public class ProductNotFoundException extends Exception {
	
	public ProductNotFoundException() {
		
	}
	
	/**
	 *To string method to give the proper message. 
	 */
	public String toString() {
		
		return "The given product does not exist!";
		
	}
}