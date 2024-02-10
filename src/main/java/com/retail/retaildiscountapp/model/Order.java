package com.retail.retaildiscountapp.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotNull;

public class Order implements IOrder{

	@NotNull(message = "UserId can not be null")
	private String userId;
	
	@NotNull(message="No order found")
	private List<IProduct> orders;
	
	public Order(String userId, List<Product> orders) {
		this.userId = userId;
		this.orders = new ArrayList<>(orders);
	}

	public String getUserId() {
		return userId;
	}

	public List<IProduct> getOrders() {
		return orders;
	}
	
}
