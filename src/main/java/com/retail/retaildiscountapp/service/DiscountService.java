package com.retail.retaildiscountapp.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.retaildiscountapp.discount.IDiscount;
import com.retail.retaildiscountapp.model.IOrder;
import com.retail.retaildiscountapp.model.IProduct;
import com.retail.retaildiscountapp.model.IUser;
import com.retail.retaildiscountapp.model.User;

/**
 * This is the service class which will calculate the total discount and final payable bill
 */
@Service
public class DiscountService {
	
	@Autowired
	DiscountFactory discountFactory;
	
	@Autowired
    private Map<String, User> users;

	/**
	 * This method is to determine the final bill based on the order
	 * 
	 * @return This will return the final payable amount for an user
	 */
	public double calculateNetPayableAmount(IOrder order) {
		List<IProduct> orderList = order.getOrders();
		String userId = order.getUserId();
		IUser user = users.get(userId);
		
		double totalBill = 0.0;
		
		for (IProduct item : orderList) {
			double bill = item.getQuantity() * item.getPrice();
			IDiscount applicableDis = discountFactory.getDiscountForUser(item, user);
			double discountAmount = applicableDis.calculateDiscount(bill);
			totalBill+= bill - discountAmount - calculateHundredDollarDiscounts(bill-discountAmount);
		}
        return totalBill;	
	}
	

	/**
	 * 
	 * @return this will return another $5 discount for every $100 bills
	 */
	public double calculateHundredDollarDiscounts( double billAmount) {
        double numHundreds =  Math.floor(billAmount / 100);
        return numHundreds*5;
    }

}
