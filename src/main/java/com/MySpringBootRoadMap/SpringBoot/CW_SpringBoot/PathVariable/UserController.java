package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.PathVariable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    //GET http://localhost:8080/user/John
    @GetMapping("/user/{name}")
    public String getUser(@PathVariable String name){
        return "Welcome " + name ;
    }
}
