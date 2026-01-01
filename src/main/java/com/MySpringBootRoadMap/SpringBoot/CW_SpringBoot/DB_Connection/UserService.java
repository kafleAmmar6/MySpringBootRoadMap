package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DB_Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    //Autowired for Getting Input from JSON to UserModel
    @Autowired
    private UserRepository userRepository;


    public String signup(UserModel userModel) {

        //Getting all input from JSON to UserModel
        Integer UserId = userModel.getUserId();
        String UserName = userModel.getUserName();
        String UserPassword = userModel.getUserPassword();
        String UserAddress = userModel.getUserAddress();
        String UserPhone = userModel.getUserPhone();



        //Setting all input to Repository by Making Object
        UserDetail userDetail = new UserDetail();

        //Setting all input to UserDetail by making Object
        userDetail.setUserId(UserId);
        userDetail.setUserName(UserName);
        userDetail.setUserPassword(UserPassword);
        userDetail.setUserAddress(UserAddress);
        userDetail.setUserPhone(UserPhone);

        //Setting User Input in Repository
        UserDetail saveDetail = userRepository.save(userDetail);

        //To check it is saved or not
        if (saveDetail == null) {
            return "Unsuccessful";
        }
        return "Successful";
    }
}

