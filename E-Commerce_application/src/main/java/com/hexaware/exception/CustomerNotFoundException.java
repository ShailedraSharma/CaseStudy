package com.hexaware.exception;

/**
 * @author Shailendra Sharma
 * This class has the exception for scenario when customer is not found in system
 */
public class CustomerNotFoundException extends Exception {
	
	public CustomerNotFoundException() {
	}
	
	/**
	 *To string method to give the proper message.
	 */
	public String toString() {
		
		return "The given Customer does not exist!";
		
	}
}