package com.retail.retaildiscountapp.model;
import org.apache.commons.lang3.Validate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class User implements IUser {
	
	
	private boolean isEmployee;
	private boolean isAffiliate;
	
	@Min(value=0, message="Enter the number of years you are associated with the store")
	private long memberSinceYears;
	
	@NotNull(message="No order found")
	private IProduct orders; 
	
	public User(boolean isEmployee, boolean isAffiliate, long memberSinceYears, Product orders) {
		this.isEmployee = isEmployee;
		this.isAffiliate = isAffiliate;
		this.memberSinceYears = memberSinceYears;
		Validate.isTrue(orders.getPrice() > 50, "Minimum purchase value is 50");
		this.orders = orders;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public boolean isAffiliate() {
		return isAffiliate;
	}

	public void setAffiliate(boolean isAffiliate) {
		this.isAffiliate = isAffiliate;
	}

	public long getMemberSinceYears() {
		return memberSinceYears;
	}

	public void setMemberSinceYears(long memberSinceYears) {
		this.memberSinceYears = memberSinceYears;
	}

	public IProduct getOrders() {
		return orders;
	}

	public void setOrders(IProduct orders) {
		this.orders = orders;
	}
	

}
