package com.retail.retaildiscountapp.discount;

public class EmployeeDiscount implements IDiscount {

	@Override
	public double calculateDiscount(double billAmount) {
		return billAmount*0.3;
	}

}
