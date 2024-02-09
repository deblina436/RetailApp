package com.retail.retaildiscountapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.retail.retaildiscountapp.model.Product;
import com.retail.retaildiscountapp.model.User;
import com.retail.retaildiscountapp.service.DiscountService;

@SpringBootTest
public class DiscountAppServiceTest {
	


    @Autowired
    private DiscountService discountService;

    @Test
    public void testCalculateNetPayableAmount_EmployeeDiscount() {
    	Product item = new Product("iPhone", 5000, 2);
        User user = new User(true, false, 2, item);
        
        double expectedAmount = 6500.0; 
        double actualAmount = discountService.calculateNetPayableAmount(user);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_AffiliateDiscount() {
    	Product item = new Product("iPhone", 5000, 2);
        User user = new User(false, true, 4, item);
      
        double expectedAmount = 9499.9;
        double actualAmount = discountService.calculateNetPayableAmount(user);

        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_NoDiscount() {
    	Product item = new Product("iPhone", 5000, 2);
        User user = new User(false, false, 1, item);
        // Groceries present: no discounts

        double expectedAmount = 9500.0; // No discounts applied
        double actualAmount = discountService.calculateNetPayableAmount(user);
        assertEquals(expectedAmount, actualAmount);
    }

    @Test
    public void testCalculateNetPayableAmount_CustomerDiscount() {
    	Product item = new Product("iPhone", 5000, 2);
        User user = new User(false, false, 4, item);
        double expectedAmount = 9000.0;  // 210 - 10 (hundred dollar discount) - 0 (no other discounts)

        double actualAmount = discountService.calculateNetPayableAmount(user);

        assertEquals(expectedAmount, actualAmount);
    }

//    @org.junit.jupiter.api.Test
//    public void testCalculateHundredDollarDiscounts_EdgeCase() {
//        User user = new User(false, false, 9);
//        Bill bill = new Bill(99, user, false);
//
//        double expectedAmount = 99.0; // Bill amount below $100 threshold, no discount
//
//        double actualAmount = discountService.calculateNetPayableAmount(user, false, bill);
//
//        assertEquals(expectedAmount, actualAmount, 0.01);
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testDetermineApplicableDiscounts_Employee() {
//        User user = new User(true, false, 2);
//        boolean groceriesPresent = false;
//        double billAmount = 200;
//
//        List<Discount> expectedDiscounts = Collections.singletonList(new EmployeeDiscount());
//
//        List<Discount> actualDiscounts = discountService.determineApplicableDiscounts(user, groceriesPresent, billAmount);
//
//        assertEquals(expectedDiscounts, actualDiscounts);
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testDetermineApplicableDiscounts_Affiliate() {
//        User user = new User(false, true, 1);
//        boolean groceriesPresent = false;
//        double billAmount = 200;
//
//        List<Discount> expectedDiscounts = Collections.singletonList(new AffiliateDiscount());
//
//        List<Discount> actualDiscounts = discountService.determineApplicableDiscounts(user, groceriesPresent, billAmount);
//
//        assertEquals(expectedDiscounts, actualDiscounts);
//    }
//
//    @org.junit.jupiter.api.Test
//    public void testDetermineApplicableDiscounts_NoDiscount_Groceries() {
//        User user = new User(true, true, 8); // Both employee and affiliate
//        boolean groceriesPresent = true;
//        double billAmount = 100;
//
//        List<Discount> expectedDiscounts = Collections.emptyList();
//
//        List<Discount> actualDiscounts = discountService.determineApplicableDiscounts(user, groceriesPresent, billAmount);
//
//        assertEquals(expectedDiscounts, actualDiscounts);
//    }

    // Add more test cases for other edge cases and specific discount rules


}
