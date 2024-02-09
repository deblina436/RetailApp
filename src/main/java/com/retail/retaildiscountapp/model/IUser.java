package com.retail.retaildiscountapp.model;

import java.util.List;

public interface IUser {

	
	public boolean isEmployee();
	public boolean isAffiliate();
	public long getMemberSinceYears();
	
	public void setOrders(IProduct orders);
	public IProduct getOrders();
	
}
