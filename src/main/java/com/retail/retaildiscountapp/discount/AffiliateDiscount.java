package com.retail.retaildiscountapp.discount;


/**
 * This class implements IDiscount for affiliate users
 */
public class AffiliateDiscount implements IDiscount {

	/**
	 * This method is to calculate the discount applicable for a affiliate user
	 * 
	 * 	 * 
	 * @return The discount applicable for an affiliate user.
	 */
	@Override
	public double calculateDiscount(double billAmount) {
		return 0.1;
	}

}
