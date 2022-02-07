package com.example.demo.student.controller;

import com.example.demo.student.data.models.StudentData;
import com.example.demo.student.model.GetStudents;
import com.example.demo.student.model.GetStudentsResponse;
import com.example.demo.student.model.types.StudentModel;
import com.example.demo.student.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final IStudentService studentService;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentController(IStudentService studentService, ModelMapper modelMapper) {
        this.studentService = studentService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public GetStudentsResponse getStudents(GetStudents request) {
        var students = studentService.getStudents();
        var studentsModel = students.stream()
                .map(student -> modelMapper.map(student, StudentModel.class)).toList();

        var result = new GetStudentsResponse();
        result.students = studentsModel;

        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerNewStudent(@RequestBody StudentData student) {
        studentService.createNewStudent(student);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
        @PathVariable("id") Long id,
        @RequestParam(required = false) String name,
        @RequestParam(required = false) String email
    ) { studentService.updateStudent(id, name, email);}
}
