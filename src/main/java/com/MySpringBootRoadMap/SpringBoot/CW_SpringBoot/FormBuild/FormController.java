package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.FormBuild;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @GetMapping("/form/{name}/{address}/{phone}/{email}")
    public String formDetail(
            @PathVariable String name,
            @PathVariable String address,
            @PathVariable String phone,
            @PathVariable String email) {

        try {

            // Name validation
            if (name.trim().isEmpty())
                throw new MyFormException("Name cannot be empty!");
            if (!name.matches("[a-zA-Z ]+"))
                throw new MyFormException("Name must contain only letters!");

            // Address validation
            if (address.trim().isEmpty())
                throw new MyFormException("Address cannot be empty!");

            // Phone validation
            if (!phone.matches("\\d{10}"))
                throw new MyFormException("Phone number must be exactly 10 digits!");

            // Email validation
            if (!email.contains("@gmail.com"))
                throw new MyFormException("Invalid email format!");

            return "Welcome !! to Form Registration."+ "<br><br>"+
                    "Name : " + name + "<br>" +
                    "Address : " + address + "<br>" +
                    "Phone : " + phone + "<br>" +
                    "Email : " + email + "<br><br>" +
                    "✅ Form submitted successfully!";

        } catch (MyFormException e) {
            return "❌ Error: " + e.getMessage(); }
    }
}

