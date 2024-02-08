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

        User u1 = new User(null, "Ana Amarelo", "anaamarelo@gmail.com", "AnaM123");
        User u2 = new User(null, "João Azul", "joaoazul@gmail.com", "JoaoA123");
        User u3 = new User(null, "Maria Branco", "mariabranco@gmail.com", "MariaB123");
        User u4 = new User(null, "Pedro Cinza", "pedrocinza@gmail.com", "PedroC123");
        User u5 = new User(null, "Clara Dourado", "claradourado@gmail.com", "ClaraD123");
        User u6 = new User(null, "Fernando Verde", "fernandoverde@gmail.com", "FernandoV123");
        User u7 = new User(null, "Gabriela Laranja", "gabrielalaranja@gmail.com", "GabrielaL123");
        User u8 = new User(null, "Hugo Preto", "hugopreto@gmail.com", "HugoP123");
        User u9 = new User(null, "Isabela Rosa", "isabelarosa@gmail.com", "IsabelaR123");
        User u10 = new User(null, "Rafael Roxo", "rafaelroxo@gmail.com", "RafaelR123");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));

    }

}