package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.StudentAddDB;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @MongoId
    private Integer rollNumber;

    private String name;
    private String email;
    private String course;
}


