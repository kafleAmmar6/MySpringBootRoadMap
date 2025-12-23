package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DetailAdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

@RestController
public class MyLoginController {

    @Autowired
    private DetailGetterSetter detailGetterSetter;

    @GetMapping("/login/{userId}/{userPin}")
    public String loginDetail(
            @PathVariable String userId,
            @PathVariable String userPin) {

        String id = detailGetterSetter.getUserId();
        String pin = detailGetterSetter.getUserPin();

        if (Objects.equals(userId, id) && Objects.equals(userPin, pin)) {

            String fileName = "Detail.txt";
            File file = new File(System.getProperty("java.io.tmpdir"), fileName);

            try {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getAbsolutePath());
                } else {
                    System.out.println("File already exists: " + file.getAbsolutePath());
                }

                try (FileWriter fileWriter = new FileWriter(file)) {
                    fileWriter.write("Name : " + detailGetterSetter.getName() + "\n");
                    fileWriter.write("Address : " + detailGetterSetter.getAddress() + "\n");
                    fileWriter.write("Phone : " + detailGetterSetter.getPhone() + "\n");
                    fileWriter.write("Email : " + detailGetterSetter.getEmail() + "\n");
                }

                return "✅ Successfully wrote details to file at: " + file.getAbsolutePath();

            } catch (IOException e) {
                e.printStackTrace();
                return "❌ Exception occurred: " + e.getMessage();
            }

        } else {
            return "❌ Your Id and Pin are incorrect.";
        }
    }
}






