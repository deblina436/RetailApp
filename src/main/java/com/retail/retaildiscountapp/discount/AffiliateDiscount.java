package com.retail.retaildiscountapp.discount;

public class AffiliateDiscount implements IDiscount {

	@Override
	public double calculateDiscount(double billAmount) {
		return 0.1;
	}

}
