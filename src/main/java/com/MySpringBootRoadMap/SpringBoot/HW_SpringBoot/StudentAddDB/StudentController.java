package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.StudentAddDB;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // ADD STUDENT
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    // GET ALL STUDENTS
    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // GET STUDENT BY ROLL NUMBER
    @GetMapping("/roll/{rollNumber}")
    public Student getStudent(@PathVariable Integer rollNumber) {
        return service.getStudentByRoll(rollNumber);
    }

    // UPDATE STUDENT
    @PutMapping("/update/roll/{rollNumber}")
    public Student updateStudent(
            @PathVariable Integer rollNumber,
            @RequestBody Student student) {
        return service.updateStudent(rollNumber, student);
    }

    // DELETE STUDENT
    @DeleteMapping("/delete/roll/{rollNumber}")
    public String deleteStudent(@PathVariable Integer rollNumber) {
        service.deleteStudent(rollNumber);
        return "Student deleted successfully";
    }
}

