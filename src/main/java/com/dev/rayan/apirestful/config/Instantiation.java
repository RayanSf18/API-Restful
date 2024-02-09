package com.dev.rayan.apirestful.config;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.dtos.AuthorDTO;
import com.dev.rayan.apirestful.repositories.PostRepository;
import com.dev.rayan.apirestful.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "maria123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "alexA123");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com", "bob123");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null, dateFormat.parse("21/03/2018 - 21:34"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, dateFormat.parse("23/03/2018 - 07:30"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepository.saveAll(Arrays.asList(p1,p2));
    }

}