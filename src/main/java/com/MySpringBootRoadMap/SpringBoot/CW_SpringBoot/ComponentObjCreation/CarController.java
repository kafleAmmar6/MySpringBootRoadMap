package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.ComponentObjCreation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    @Autowired
    private Car car;

    @GetMapping("/drive")
    public String driveCar(){
        return car.drive();
    }
}
