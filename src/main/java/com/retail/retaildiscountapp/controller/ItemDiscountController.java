package com.retail.retaildiscountapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.retaildiscountapp.model.Order;
import com.retail.retaildiscountapp.service.DiscountService;

import jakarta.validation.Valid;

/**
 * This is the controller class.
 */
@RestController
@RequestMapping("/api/v1/")
public class ItemDiscountController {
	
	@Autowired
	DiscountService discountService;
	
	 /**
     * Returns a double as final payable amount
     *
     * <p>
     *    The controller class has only one post endpoint to calculate the netpayable amount.
     * </p>
     *
     * @return The final payable amount for a particular order.
     */
	@PostMapping("/calculateDiscount")
	public ResponseEntity<Double> calculateNetPayableAmount(@Valid @RequestBody Order order){
		
		double netPayableAmount = discountService.calculateNetPayableAmount(order);
        return ResponseEntity.ok(netPayableAmount);
		
	}
	
	

}
