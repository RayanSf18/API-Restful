package com.dev.rayan.apirestful.config;

import com.dev.rayan.apirestful.domain.Post;
import com.dev.rayan.apirestful.domain.User;
import com.dev.rayan.apirestful.dtos.AuthorDTO;
import com.dev.rayan.apirestful.dtos.CommentDTO;
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

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "maria123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "alexA123");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com", "bob123");

        userRepository.saveAll(Arrays.asList(u1,u2,u3));

        Post p1 = new Post(null, dateFormat.parse("21/03/2018"), "Partiu Viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, dateFormat.parse("23/03/2018"), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(u1));

        postRepository.saveAll(Arrays.asList(p1,p2));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", dateFormat.parse("21/03/2018"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Aproveite!", dateFormat.parse("22/03/2018"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia!", dateFormat.parse("23/03/2018"), new AuthorDTO(u2));

        p1.getComments().addAll(Arrays.asList(c1,c2));
        p2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(p1,p2));

        u1.getPosts().addAll(Arrays.asList(p1,p2));

        userRepository.save(u1);
    }

}