package com.retail.retaildiscountapp.service;


import org.springframework.stereotype.Service;
import com.retail.retaildiscountapp.discount.AffiliateDiscount;
import com.retail.retaildiscountapp.discount.CustomerDiscount;
import com.retail.retaildiscountapp.discount.EmployeeDiscount;
import com.retail.retaildiscountapp.discount.IDiscount;
import com.retail.retaildiscountapp.discount.NoDiscount;
import com.retail.retaildiscountapp.model.IProduct;
import com.retail.retaildiscountapp.model.IUser;
import com.retail.retaildiscountapp.model.ProductType;

@Service
public class DiscountFactory {

	IDiscount getDiscountForUser(IProduct product, IUser user) {
		String name = product.getName();
		if(product.getProductType(name)!=ProductType.GROCERIES) {
			if (user.isEmployee()) {
				return new EmployeeDiscount();
			} else if (user.isAffiliate()) {
				return new AffiliateDiscount();
			} else if (user.getMemberSinceYears() > 2) {
				return new CustomerDiscount();
			}
		}	
		return new NoDiscount();
	}
}