package com.codewithmosh.store;

import com.codewithmosh.store.entities.Address;
import com.codewithmosh.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
//        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
//        var user = new User();
        var user = User.builder()
                .name("John")
                .password("password")
                .email("john@codewithmosh.com")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .zip("zip")
                .build();

        user.addAddress(address);
        System.out.println(user);
    }
}
