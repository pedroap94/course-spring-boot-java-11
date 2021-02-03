package com.example.course.course.config;

import com.example.course.course.entities.Category;
import com.example.course.course.entities.Order;
import com.example.course.course.entities.Product;
import com.example.course.course.entities.User;
import com.example.course.course.entities.enums.OrderStatus;
import com.example.course.course.repositories.CategoryRepository;
import com.example.course.course.repositories.OrderRepository;
import com.example.course.course.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.WAITING_PAYMENT);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.PAID);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.DELIVERED);



        userRepository.saveAll(Arrays.asList(u1,u2)); //salva uma lista no banco de dados. Por isso tivemos que criar o Arrays.asList
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
