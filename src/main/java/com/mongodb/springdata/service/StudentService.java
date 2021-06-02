package com.mongodb.springdata.service;

import com.mongodb.springdata.model.Student;
import com.mongodb.springdata.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Philémon Globléhi <philemon.globlehi@gmail.com>
 */
@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(String id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student student) {
        return studentRepository.insert(student);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public void removeStudent(Student student) {
        studentRepository.delete(student);
    }
}
