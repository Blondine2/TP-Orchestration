package com.eshop.ms.model;

public class Product {
	private int id;
	private String productName;
	private int price;
	
	public Product() {}
	
	public Product(int i, String name, int j) {
		this.id = i;
		this.productName = name;
		this.price =j;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
