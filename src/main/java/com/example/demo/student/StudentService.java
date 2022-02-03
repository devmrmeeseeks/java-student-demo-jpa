package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll().stream().unordered().toList();
    }

    public void createNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent())
            throw new IllegalStateException("Email taken");

        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException(String.format("Student with Id %s does not exists", id));

        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository
                .findById(id).orElseThrow(() -> new IllegalStateException(
                        String.format("Student with id %s does not exists", id)
                ));

        if (null != name && !name.isEmpty() && !student.getName().equals(name))
            student.setName(name);

        if (null != email && !email.isEmpty() && !student.getEmail().equals(email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent())
                throw new IllegalStateException("Email is taken");
        }

        student.setEmail(email);
    }
}
