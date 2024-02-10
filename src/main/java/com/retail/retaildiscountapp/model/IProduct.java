package com.retail.retaildiscountapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface IProduct {

	public double getPrice();
	public int getQuantity();
	@JsonIgnore
	public ProductType getProductType(String name);
	public String getName();
}
