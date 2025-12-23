package com.MySpringBootRoadMap.SpringBoot.CW_SpringBoot.DetailAdd;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // New instance per request
public class DetailGetterSetter {

    private String name;
    private String address;
    private String phone;
    private String email;
    private String userId;
    private String userPin;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getUserPin() { return userPin; }
    public void setUserPin(String userPin) { this.userPin = userPin; }
}

