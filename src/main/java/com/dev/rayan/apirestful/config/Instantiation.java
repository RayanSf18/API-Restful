package com.dev.rayan.apirestful.config;

import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User u1 = new User(null, "Ana Amarelo", "anaamarelo@gmail.com");
        User u2 = new User(null, "João Azul", "joaoazul@gmail.com");
        User u3 = new User(null, "Maria Branco", "mariabranco@gmail.com");
        User u4 = new User(null, "Pedro Cinza", "pedrocinza@gmail.com");
        User u5 = new User(null, "Ana Laranja", "analaranja@gmail.com");
        User u6 = new User(null, "João Verde", "joaoverde@gmail.com");
        User u7 = new User(null, "Maria Rosa", "mariarosa@gmail.com");
        User u8 = new User(null, "Pedro Roxo", "pedroroxo@gmail.com");
        User u9 = new User(null, "Ana Violeta", "anavioleta@gmail.com");
        User u10 = new User(null, "João Vermelho", "joaovermelho@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));

    }

}