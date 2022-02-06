package com.example.demo.student.data.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
public class StudentData {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    @Transient
    private Integer age;

    public StudentData() {

    }

    public StudentData(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public Integer getAge() {
                         return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
}
