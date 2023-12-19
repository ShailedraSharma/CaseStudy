package com.hexaware.entity;

import java.util.Date;

/*
 * @author shailendra sharma
 */
/*
 * This class represents order
 */
public class Order {
	private long orderId;
	private long customerId;
	private Date orderDate;
	private int totalPrice;
	private String shippingAddress;
	
	/**
	 * @param orderId represents the id of order
	 * @param customerId represents the customer id related to order
	 * @param orderDate represents the order date
	 * @param totalPrice represents total price of order
	 * @param shippingAddress represents shipping address of order
	 */
	public Order(long orderId, long customerId, Date orderDate, int totalPrice, String shippingAddress) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.shippingAddress = shippingAddress;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
}
