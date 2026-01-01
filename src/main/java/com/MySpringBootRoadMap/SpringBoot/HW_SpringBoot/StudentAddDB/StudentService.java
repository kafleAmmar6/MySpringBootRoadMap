package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.StudentAddDB;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Student saveStudent(Student student) {
        if (student.getRollNumber() == null) {
            throw new IllegalArgumentException("Roll number must be provided");
        }
        return repository.save(student);
    }

    // READ ALL
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // READ BY ROLL NUMBER
    public Student getStudentByRoll(Integer rollNumber) {
        return repository.findById(rollNumber).orElse(null);
    }

    // UPDATE
    public Student updateStudent(Integer rollNumber, Student student) {
        Student existing = repository.findById(rollNumber).orElse(null);

        if (existing == null) {
            return null;
        }

        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setCourse(student.getCourse());

        return repository.save(existing);
    }

    // DELETE
    public void deleteStudent(Integer rollNumber) {
        repository.deleteById(rollNumber);
    }
}

