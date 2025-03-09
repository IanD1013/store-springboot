package com.codewithmosh.store.services;

import com.codewithmosh.store.entities.*;
import com.codewithmosh.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final EntityManager entityManager;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        var address = Address.builder()
                .street("street")
                .city("city")
                .zip("zip")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        // Delete parent entity
        // userRepository.deleteById(1L);

        // Delete child entity
        var user = userRepository.findById(1L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void manageProducts() {
        productRepository.deleteById(1L);
    }

    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUsers() {
        var user = userRepository.findAllWithAddresses();
        user.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

}
