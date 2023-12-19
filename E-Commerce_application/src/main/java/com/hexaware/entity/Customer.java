package com.hexaware.entity;

/*
 * @author Shailendra Sharma
 */
/*This class represent customer
 */
public class Customer {
	private long customerId;
	private String name;
	private String email;
	private String password;
	
	/**
	 * @param customerId represents the customer id
	 * @param name represents customer name
	 * @param email represents customer email
	 * @param password represents customer password
	 * Paramaterized constructor for customer class
	 */
	public Customer(long customerId, String name, String email, String password) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public Customer() {
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
