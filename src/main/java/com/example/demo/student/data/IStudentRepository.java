package com.example.demo.student.data;

import com.example.demo.student.data.models.StudentData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<StudentData, Long> {

//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<StudentData> findStudentByEmail(String email);
}
