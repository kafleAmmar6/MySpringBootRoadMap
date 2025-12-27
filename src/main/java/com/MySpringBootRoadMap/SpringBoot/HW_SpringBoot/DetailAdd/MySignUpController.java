package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.DetailAdd;

import com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.FormBuild.MyFormException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

@RestController
public class MySignUpController {


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


            // Address validation
            if (address.trim().isEmpty())
                throw new MyDetailException("Address cannot be empty!");


            // Phone validation
            if (!phone.matches("\\d{10}"))
                throw new MyDetailException("Phone number must be exactly 10 digits!");


            // Email validation
            if (!email.contains("@gmail.com"))
                throw new MyDetailException("Invalid email format!");


            // Generate UserId and Pin
            Random random = new Random();
            String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder userIdBuilder = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                int index = random.nextInt(chars.length());
                userIdBuilder.append(chars.charAt(index));
            }
            String userId = userIdBuilder.toString();
            int userPin = 1000 + random.nextInt(9000);

            String fileName =name.toLowerCase()+".txt";
            File file = new File(fileName);

            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists: " + file.getAbsolutePath());
                }

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write("Name : " + name + "\n");
                    fileWriter.write("Address : " + address + "\n");
                    fileWriter.write("Phone : " + phone + "\n");
                    fileWriter.write("Email : " + email + "\n");
                    fileWriter.write("User-Id : " + userId+"\n");
                    fileWriter.write("User-Pin : " + userPin+"\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "❌ Exception occurred: " + e.getMessage();
            }

            return "✅ Successfully wrote details to file at: " + file.getAbsolutePath()+ "<br>" +
                    "Name : " + name + "<br>" +
                    "Address : " + address + "<br>" +
                    "Phone : " + phone + "<br>" +
                    "Email : " + email + "<br> <br>" +
                    "User-Id: " + userId + "<br>" +
                    "User-Pin: " + userPin + "<br>" +
                    "✅ Sign-Up successful!<br><br>" ;

        } catch (MyDetailException e) {
            return "❌ Error: " + e.getMessage();
        }


    }
}




