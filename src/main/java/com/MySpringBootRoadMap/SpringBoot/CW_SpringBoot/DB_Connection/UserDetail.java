package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DB_Connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetail {

    @MongoId
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userAddress;
    private String userPhone;

}

