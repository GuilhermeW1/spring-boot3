package com.example.demo.config;

import com.example.demo.entities.Category;
import com.example.demo.entities.Order;
import com.example.demo.entities.User;
import com.example.demo.entities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "997907949", "12345678");
        User u2 = new User(null, "Alex", "alex@gmail.com", "992282380", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID,u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
