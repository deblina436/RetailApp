package com.retail.retaildiscountapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.retaildiscountapp.exception.InvalidArgumentException;
import com.retail.retaildiscountapp.model.User;
import com.retail.retaildiscountapp.service.DiscountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/")
public class ItemDiscountController {
	
	@Autowired
	DiscountService discountService;
	
	@PostMapping("/calculateDiscount")
	public ResponseEntity<Double> calculateNetPayableAmount(@Valid @RequestBody User user){
		
		double netPayableAmount = discountService.calculateNetPayableAmount(user);
        return ResponseEntity.ok(netPayableAmount);
		
	}
	
	

}
