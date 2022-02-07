package com.example.demo.student.configuration;

import com.example.demo.student.data.IStudentRepository;
import com.example.demo.student.data.models.StudentData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(IStudentRepository repository) {
        return args -> {
            StudentData robert = new StudentData(
                "Robert",
                "robert@test.com",
                LocalDate.of(1988, Month.MAY, 29)
            );

            StudentData estuardo = new StudentData(
                    "Estuardo",
                    "estuardo@test.com",
                    LocalDate.of(1989, Month.MAY, 29)
            );

            repository.saveAll(List.of(robert, estuardo));
        };
    }
}
