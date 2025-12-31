package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.JsonRequestAndResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class ClientController {

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
    public String  addClient(@RequestBody Client client){

        System.out.println("Id : " + client.getId());
        System.out.println("Name : " + client.getName());
        System.out.println("Age : " + client.getAge());
        return " Program run succesgully !!";
    }
}
