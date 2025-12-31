package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.StudentResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/students")
public class StudentController {
    // Adding Student Detail
    @GetMapping("/add/{studentName}/{studentClassLevel}")
    public String addStudent(@PathVariable String studentName, @PathVariable String studentClassLevel) {

        return " Hello " + studentName + " Thanks for giving your detail. ";
    }
}