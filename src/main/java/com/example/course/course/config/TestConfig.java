package com.example.course.course.config;

import com.example.course.course.entities.Category;
import com.example.course.course.entities.Order;
import com.example.course.course.entities.User;
import com.example.course.course.entities.enums.OrderStatus;
import com.example.course.course.repositories.CategoryRepository;
import com.example.course.course.repositories.OrderRepository;
import com.example.course.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration //indica que está é uma classe apenas de configuração, ou seja, é uma classe de teste
@Profile("test") //esse nome tem que ser igual ao que está no application.properties em profile. Assim o spring entende que essa configuração só será rodada no perfil de teste
public class TestConfig implements CommandLineRunner {

    @Autowired //implementa automaticamente. Esse é o jeito que declaramos uma implementação quando usamos Spring
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);



        userRepository.saveAll(Arrays.asList(u1,u2)); //salva uma lista no banco de dados. Por isso tivemos que criar o Arrays.asList
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
