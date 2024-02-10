package com.retail.retaildiscountapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.retail.retaildiscountapp.model.Order;
import com.retail.retaildiscountapp.model.Product;
import com.retail.retaildiscountapp.service.DiscountService;

@SpringBootTest
class DiscountAppServiceTest {
	
    @Autowired
    private DiscountService discountService;
    
    private List<Product> products;
    
    @BeforeEach
    void setUp() {
        // Initialize your dataset here
    	products = Arrays.asList(
                new Product("tablet", 100, 2),
                new Product("tv", 200, 1),
                new Product("milk", 10, 3),
                new Product("biscuts", 30, 1)
        );
    }

    @Test
    void testCalculateNetPayableAmount_EmployeeDiscount() {
        Order order = new Order("Deb123", products);        
        double expectedAmount = 311.0; 
        double actualAmount = discountService.calculateNetPayableAmount(order);
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void testCalculateNetPayableAmount_AffiliateDiscount() {
    	Order order = new Order("Sri456", products);   
      
        double expectedAmount = 439.7;
        double actualAmount = discountService.calculateNetPayableAmount(order);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void testCalculateNetPayableAmount_NoDiscount() {
    	 Order order = new Order("Raj345", products);   
        // Groceries present: no discounts

        double expectedAmount = 440.0; // No discounts applied
        double actualAmount = discountService.calculateNetPayableAmount(order);
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void testCalculateNetPayableAmount_CustomerDiscount() {
    	Order order = new Order("Ravi90", products);   
        double expectedAmount = 418.5;  

        double actualAmount = discountService.calculateNetPayableAmount(order);

        assertEquals(expectedAmount, actualAmount);
    }
    
}
