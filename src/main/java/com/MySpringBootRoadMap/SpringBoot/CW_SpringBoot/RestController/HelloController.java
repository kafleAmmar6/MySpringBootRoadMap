package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //GET http://localhost:8080/hello
    @GetMapping("/hello")
    public String hello(){
        return "Hello Ammar Kafle";
    }
}
