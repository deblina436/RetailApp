package com.retail.retaildiscountapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.retaildiscountapp.discount.IDiscount;
import com.retail.retaildiscountapp.model.IProduct;
import com.retail.retaildiscountapp.model.IUser;


@Service
public class DiscountService {
	
	@Autowired
	DiscountFactory discountFactory;

	public double calculateNetPayableAmount(IUser user) {
		IProduct item = user.getOrders();
		double bill = item.getQuantity() * item.getPrice();
		
		IDiscount applicableDis = discountFactory.getDiscountForUser(user);
		double discountAmount = applicableDis.calculateDiscount(bill);
		
        return bill - discountAmount - calculateHundredDollarDiscounts(bill);		
	}
	

	public double calculateHundredDollarDiscounts( double billAmount) {
        int numHundreds = (int) Math.floor(billAmount / 100);
        return (double)numHundreds*5;
    }

}
