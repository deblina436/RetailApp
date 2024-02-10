package com.retail.retaildiscountapp;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.retaildiscountapp.model.Order;
import com.retail.retaildiscountapp.model.Product;
import com.retail.retaildiscountapp.service.DiscountService;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ContextConfiguration()
@ExtendWith(MockitoExtension.class)
class DiscountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Mock
    private DiscountService discountService;


    @Test
    void testCalculateNetPayableAmount() throws Exception {

    	List<Product> products = Arrays.asList(
                new Product("tablet", 100, 2),
                new Product("tv", 200, 1),
                new Product("milk", 10, 3)
        );

        Order order = new Order("Deb123", products);

        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/calculateDiscount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(order)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("290.0"));
    }
}