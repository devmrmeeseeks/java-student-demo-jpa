package com.example.demo.student.model.types;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
public class StudentModel{
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate birthDate;
}