package com.retail.retaildiscountapp.model;

import java.util.List;

public interface IOrder {

	public String getUserId();

	public List<IProduct> getOrders();
}
