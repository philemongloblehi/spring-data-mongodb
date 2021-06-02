package com.mongodb.springdata.controller;

import com.mongodb.springdata.model.Student;
import com.mongodb.springdata.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Philémon Globléhi <philemon.globlehi@gmail.com>
 */
@RestController
@RequestMapping(value = "api/v1/students", name = "app_students_")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(name = "list")
    public List<Student> fetchAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}", name = "show")
    public Optional<Student> showStudent(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    @PostMapping(name = "create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping(value = "/{id}", name = "update")
    public Student updateStudent(@RequestBody Student studentUpdated, String id) {
        Optional<Student> student = studentService.getStudent(id);
        if (!student.isPresent()) {
            throw new IllegalStateException("Student not found with id " + id);
        }

        return studentService.updateStudent(studentUpdated);
    }

    @DeleteMapping(value = "/{id}", name = "remove")
    public void removeStudent(@PathVariable String id) {
        Optional<Student> student = studentService.getStudent(id);
        if (!student.isPresent()) {
            throw new IllegalStateException("Student not found with id " + id);
        }

        studentService.removeStudent(student.get());
    }

}
