package com.chr.webapp.models;

import java.util.Objects;

public class CarItem {
	private int amount;
	private Product product;
	
	
	public CarItem(int amount, Product product) {
		
		this.amount = amount;
		this.product = product;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public double getItemTotal() {
		return amount * product.getPrice();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarItem other = (CarItem) obj;
		return Objects.equals(product.getId(), other.product.getId());
	}
}
