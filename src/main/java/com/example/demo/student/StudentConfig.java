package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student robert = new Student(
                "Robert",
                "robert@test.com",
                LocalDate.of(1988, Month.MAY, 29)
            );

            Student estuardo = new Student(
                    "Estuardo",
                    "estuardo@test.com",
                    LocalDate.of(1989, Month.MAY, 29)
            );

            repository.saveAll(List.of(robert, estuardo));
        };
    }
}
