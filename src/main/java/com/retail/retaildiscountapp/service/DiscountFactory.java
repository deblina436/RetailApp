package com.retail.retaildiscountapp.service;

import com.retail.retaildiscountapp.discount.*;
import com.retail.retaildiscountapp.model.IProduct;
import com.retail.retaildiscountapp.model.IUser;
import com.retail.retaildiscountapp.model.ProductType;

import org.springframework.stereotype.Service;

@Service
public class DiscountFactory {

    IDiscount getDiscountForUser(IUser user) {

    	IProduct product = user.getOrders();
    	String name = product.getName();
        if(user.getOrders().getProductType(name)!=ProductType.GROCERIES) {
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