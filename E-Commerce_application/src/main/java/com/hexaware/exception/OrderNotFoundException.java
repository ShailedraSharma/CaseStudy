package com.hexaware.exception;

/**
 * @author Shailendra Sharma
 * This class has the exception for scenario when order is not found in system
 */
public class OrderNotFoundException extends Exception {
	
	public OrderNotFoundException() {
		
	}
	
	/**
	 *To string method to give the proper message. 
	 */
	public String toString() {
		
		return "The given order does not exist!";
		
	}
}