package com.retail.retaildiscountapp.discount;

public class CustomerDiscount implements IDiscount {

    
	@Override
	public double calculateDiscount(double billAmount) {
		// TODO Auto-generated method stub
		return billAmount*.05;
		
	}

}