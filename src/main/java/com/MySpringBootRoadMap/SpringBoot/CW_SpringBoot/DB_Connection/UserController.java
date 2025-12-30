package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DB_Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public String signup(@RequestBody UserModel userModel) {

        String result = userService.signup(userModel);

        return result;
    }
}

