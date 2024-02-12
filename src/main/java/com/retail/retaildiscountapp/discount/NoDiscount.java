package com.retail.retaildiscountapp.discount;

/**
 * This class implements IDiscount.
 */
public class NoDiscount implements IDiscount {

	/**
	 * This method is used if customer is not eligible for any kind of discount
	 * 	 * 
	 * @return The discount applicable for a user.
	 */
	@Override
	public double calculateDiscount(double billAmount) {
		return 0;
	}

}
