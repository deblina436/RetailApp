package com.retail.retaildiscountapp.discount;

public class EmployeeDiscount implements IDiscount {

	@Override
	public double calculateDiscount(double billAmount) {
		// TODO Auto-generated method stub
		return billAmount*0.3;
	}

}
