package com.codewithmosh.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var userService = context.getBean(UserService.class);
        userService.registerUser(new User(1L, "mosh@codewithmosh.com", "1234", "Mosh"));
        userService.registerUser(new User(1L, "mosh@codewithmosh.com", "1234", "Mosh"));
    }
}
