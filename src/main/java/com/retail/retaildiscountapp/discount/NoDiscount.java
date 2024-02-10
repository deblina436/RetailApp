package com.retail.retaildiscountapp.discount;

public class NoDiscount implements IDiscount {

	@Override
	public double calculateDiscount(double billAmount) {
		return 0;
	}

}
