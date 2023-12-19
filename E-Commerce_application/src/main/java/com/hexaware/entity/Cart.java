package com.hexaware.entity;

/*
 * @author shailendra sharma
 */
/*
 * This class represents card
 */
public class Cart {
	private long cardId;
	private long customerId;
	private long productId;
	private int quantity;
	
	/**
	 * @param cardId represents card id
	 * @param customerId represents customer id related to card
	 * @param productId represents product id of the product in cart
	 * @param quantity represents the quantity of product
	 */
	public Cart(long cardId, long customerId, long productId, int quantity) {
		super();
		this.cardId = cardId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
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
