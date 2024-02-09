package com.retail.retaildiscountapp.model;

public interface IProduct {

	public double getPrice();
	public int getQuantity();
	public ProductType getProductType(String name);
	public String getName();
}
