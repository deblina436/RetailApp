package com.retail.retaildiscountapp.discount;


/**
 * This class implements IDiscount.
 */
public class EmployeeDiscount implements IDiscount {

	/**
	 * This method is to calculate the discount for a user who is an employee of the store
	 * 
	 * 	 * 
	 * @return The discount applicable for an employee user.
	 */
	@Override
	public double calculateDiscount(double billAmount) {
		return billAmount*0.3;
	}

}
