package com.retail.retaildiscountapp.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Product implements IProduct {

    private String name;
    
    @NotNull
    @Min(value=10, message = "Minimum price should be 10")
    private double price;
    private int quantity;
    
    
    public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}


	public int getQuantity() {
		return quantity;
	}
	
	@Override
	public ProductType getProductType(String name) {
        // Define common keywords for each category
        String[] groceriesKeywords = {"bread", "milk", "eggs", "fruit", "cereal"};
        String[] electronicsKeywords = {"phone", "laptop", "tablet", "tv", "camera"};

        // Check for keyword matches and return corresponding product type
        for (String keyword : groceriesKeywords) {
            if (name.toLowerCase().contains(keyword)) {
                return ProductType.GROCERIES;
            }
        }
        for (String keyword : electronicsKeywords) {
            if (name.toLowerCase().contains(keyword)) {
                return ProductType.ELECTRONICS;
            }
        }
        return ProductType.OTHERS;
    }

}
