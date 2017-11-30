package com.shop.product.service;

import com.shop.entity.Product;

public class CartItem {
	private Product product;
	private int count;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
