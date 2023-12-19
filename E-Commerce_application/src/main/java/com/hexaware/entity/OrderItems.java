package com.hexaware.entity;

/*
 * @author Shailendra Sharma
 */
/* 
* This class represents the orders items 
 */
public class OrderItems {
	private long orderItemId;
	private long orderId;
	private long productId;
	private int quantity;
	
	/**
	 * @param orderItemId represents the order item id
	 * @param orderId represents the order id 
	 * @param productId represents the product id
	 * @param quantity represents the quantity of product
	 */
	public OrderItems(long orderItemId, long orderId, long productId, int quantity) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	public long getOrderItemId() {
		return orderItemId;
	}
	
	public void setOrderItemId(long orderItemId) {
		this.orderItemId = orderItemId;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public void setProductId(long productId) {
		this.productId = productId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
