package com.example.course.course.config;

import com.example.course.course.entities.User;
import com.example.course.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //indica que está é uma classe apenas de configuração, ou seja, é uma classe de teste
@Profile("test") //esse nome tem que ser igual ao que está no application.properties em profile. Assim o spring entende que essa configuração só será rodada no perfil de teste
public class TestConfig implements CommandLineRunner {

    @Autowired //implementa automaticamente. Esse é o jeito que declaramos uma implementação quando usamos Spring
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1,u2)); //salva uma lista no banco de dados. Por isso tivemos que criar o Arrays.asList
    }
}
