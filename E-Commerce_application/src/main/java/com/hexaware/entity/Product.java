package com.hexaware.entity;

/*
 * @author Shailendra Sharma
 */
/*
 * This class represents product
 */
public class Product {
	private long productId;
	private String name;
	private int price;
	private String description;
	private int stockQuantity;
	
	
	/**
	 * @param productId represents the product id
	 * @param name represents product name
	 * @param price represents product price
	 * @param description represents product description
	 * @param stockQuantity represents product quantity
	 * Constructor for the product class
	 */
	public Product(long productId, String name, int price, String description, int stockQuantity) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.stockQuantity = stockQuantity;
	}

	public Product() {
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
