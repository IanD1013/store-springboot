package com.codewithmosh.store;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var repository = context.getBean(UserRepository.class);

//        var user = User.builder()
//                .name("John")
//                .email("john@example.com")
//                .password("password")
//                .build();
//
//        repository.save(user);

//        var user = repository.findById(1L).orElseThrow();
//        System.out.println(user.getEmail());

        repository.findAll().forEach(u -> System.out.println(u.getEmail()));

        repository.deleteById(1L);
    }
}
