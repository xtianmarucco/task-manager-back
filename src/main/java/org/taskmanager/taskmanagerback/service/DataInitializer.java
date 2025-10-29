package org.taskmanager.taskmanagerback.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.taskmanager.taskmanagerback.model.User;
import org.taskmanager.taskmanagerback.repository.UserRepository;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner loadTestUsers(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.count() == 0) {
                User user1 = new User(
                        "christian.marucco@mail.com",
                        passwordEncoder.encode("1234asdfAA"),
                        "Christian Marucco",
                        "Frontend Developer"
                );

                User user2 = new User(
                        "carlosgomez@gmail.com",
                        passwordEncoder.encode("1234asdfAA"),
                        "Carlos Gómez",
                        "Backend Developer"
                );

                User user3 = new User(
                        "lucia.torres@hotmail.com",
                        passwordEncoder.encode("1234asdf"),
                        "Lucía Torres",
                        "QA Analyst"
                );

                User user4 = new User(
                        "marcos.diaz@hotmail.com",
                        passwordEncoder.encode("1234asdf"),
                        "Marcos Díaz",
                        "UX/UI Designer"
                );

                User user5 = new User(
                        "pepe.grillo@hotmail.com",
                        passwordEncoder.encode("1234asdf"),
                        "Pepe grillo",
                        "UX/UI Designer"
                );


                userRepository.saveAll(List.of(user1, user2, user3, user5));

                System.out.println("✅ Usuarios de prueba insertados correctamente con contraseñas encriptadas.");
            } else {
                System.out.println("⚠️ Ya existen usuarios, no se insertaron nuevos registros.");
            }
        };
    }
}