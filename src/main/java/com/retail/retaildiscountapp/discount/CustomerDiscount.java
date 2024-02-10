package com.retail.retaildiscountapp.discount;

public class CustomerDiscount implements IDiscount {

    
	@Override
	public double calculateDiscount(double billAmount) {
		return billAmount*.05;
		
	}

}
