package com.retail.retaildiscountapp.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.retail.retaildiscountapp.model.User;

@Configuration
public class UserConfiguration {

    @Bean
    public Map<String, User> initializeUsers() {
        Map<String, User> users = new HashMap<>();

        
        users.put("Deb123", new User("Deb123", true, false, 5));
        users.put("Sri456", new User("Sri436", false, true, 1));
        users.put("Ravi90", new User("Ravi90", false, false, 5));
        users.put("Sai89", new User("Sai89", true, true, 2));
        users.put("Raj345", new User("Raj345", false, false, 1));
        // Add more users as needed

        return users;
    }
}