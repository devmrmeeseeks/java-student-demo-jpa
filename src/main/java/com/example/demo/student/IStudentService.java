package com.example.demo.student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();
    void createNewStudent(Student student);
    void deleteStudent(Long id);
    void updateStudent(Long id, String name, String email);
}
