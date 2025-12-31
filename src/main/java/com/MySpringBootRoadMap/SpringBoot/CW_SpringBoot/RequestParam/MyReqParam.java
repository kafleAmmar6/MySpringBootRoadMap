package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.RequestParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyReqParam {

    //GET http://localhost:8080/applicant?name=ammar&age=20
    @GetMapping("/applicant")
    public String student(@RequestParam String name,
                          @RequestParam int age){
        return "Hello " + name + ", Age : " + age;
    }
}
