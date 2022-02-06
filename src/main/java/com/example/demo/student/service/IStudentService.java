package com.example.demo.student.service;

import com.example.demo.student.data.models.StudentData;

import java.util.List;

public interface IStudentService {
    List<StudentData> getStudents();
    void createNewStudent(StudentData student);
    void deleteStudent(Long id);
    void updateStudent(Long id, String name, String email);
}
