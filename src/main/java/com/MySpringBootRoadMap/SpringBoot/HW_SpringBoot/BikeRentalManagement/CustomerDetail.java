package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetail {

    //CUSTOMER  DETAILS
    @Id
    private String customerId;
    private String customerName;
    private String customerNumber;
    private String customerEmail;
}
