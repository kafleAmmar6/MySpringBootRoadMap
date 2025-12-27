package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.JsonRequestAndResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

/*To give input in Json from server
Step 1 = in postman give url : http://localhost:8080/student/add
step 2 = make method to Post
step 3 = to give input in Json go to ram option and then in top right there is a selection option then select jason
step 4 = input Json input in curly bracket
        {
  "id": 1,
  "name": "Ammar",
  "age": 20
       }
       this is for example
* */


    @PostMapping("/add")
    public String  addStudent(@RequestBody Student student){

        System.out.println("Id : " + student.getId());
        System.out.println("Name : " + student.getName());
        System.out.println("Age : " + student.getAge());
        return " Program run succesgully !!";
    }
}
