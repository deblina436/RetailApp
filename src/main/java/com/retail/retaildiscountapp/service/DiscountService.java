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


@Service
public class DiscountService {
	
	@Autowired
	DiscountFactory discountFactory;
	
	@Autowired
    private Map<String, User> users;

	public double calculateNetPayableAmount(IOrder order) {
		List<IProduct> orderList = order.getOrders();
		String userId = order.getUserId();
		IUser user = users.get(userId);
		
		double totalBill = 0.0;
		
		for (IProduct item : orderList) {
			double bill = item.getQuantity() * item.getPrice();
			IDiscount applicableDis = discountFactory.getDiscountForUser(item, user);
			double discountAmount = applicableDis.calculateDiscount(bill);
			totalBill+= bill - discountAmount - calculateHundredDollarDiscounts(bill);
		}
        return totalBill;	
	}
	

	public double calculateHundredDollarDiscounts( double billAmount) {
        int numHundreds = (int) Math.floor(billAmount / 100);
        return (double)numHundreds*5;
    }

}
