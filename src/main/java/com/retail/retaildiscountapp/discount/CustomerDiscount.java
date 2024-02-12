package com.retail.retaildiscountapp.discount;

/**
 * This class implements IDiscount.
 */
public class CustomerDiscount implements IDiscount {

	/**
	 * This method applicable for a users who has been a customer for more than 2 years
	 * 
	 * @return The discount applicable for a user.
	 */
	@Override
	public double calculateDiscount(double billAmount) {
		return billAmount*.05;
		
	}

}
