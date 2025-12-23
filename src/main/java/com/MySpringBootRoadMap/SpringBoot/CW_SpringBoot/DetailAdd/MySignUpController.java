package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DetailAdd;

import com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.FormBuild.MyFormException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MySignUpController {

    @Autowired
    private DetailGetterSetter detailGetterSetter;

    @GetMapping("/sign-up/{name}/{address}/{phone}/{email}")
    public String signupDetail(
            @PathVariable String name,
            @PathVariable String address,
            @PathVariable String phone,
            @PathVariable String email) {

        try {
            // Name validation
            if (name.trim().isEmpty())
                throw new MyDetailException("Name cannot be empty!");
            if (!name.matches("[a-zA-Z ]+"))
                throw new MyFormException("Name must contain only letters!");
            detailGetterSetter.setName(name);

            // Address validation
            if (address.trim().isEmpty())
                throw new MyDetailException("Address cannot be empty!");
            detailGetterSetter.setAddress(address);

            // Phone validation
            if (!phone.matches("\\d{10}"))
                throw new MyDetailException("Phone number must be exactly 10 digits!");
            detailGetterSetter.setPhone(phone);

            // Email validation
            if (!email.contains("@gmail.com"))
                throw new MyDetailException("Invalid email format!");
            detailGetterSetter.setEmail(email);

            // Generate UserId and Pin
            Random random = new Random();
            String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder userIdBuilder = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(chars.length());
                userIdBuilder.append(chars.charAt(index));
            }
            String userId = userIdBuilder.toString();
            detailGetterSetter.setUserId(userId);

            int userPin = 1000 + random.nextInt(9000);
            detailGetterSetter.setUserPin(String.valueOf(userPin));

            return "Name : " + name + "<br>" +
                    "Address : " + address + "<br>" +
                    "Phone : " + phone + "<br>" +
                    "Email : " + email + "<br> <br>" +
                    "✅ Sign-Up successful!<br><br>" +
                    "User-Id: " + userId + "<br>" +
                    "User-Pin: " + userPin;

        } catch (MyDetailException e) {
            return "❌ Error: " + e.getMessage();
        }
    }
}




