package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagementProject.CustomersCode;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(collection = "CUSTOMERS DATA")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private Integer customerId;

    private String customerName;
    private String customerPhone;
    private String customerAddress;

    private String issuedbikeModel;
    private String issuedbikeBrand;
    private Long issuedbikeCc;

    private Double rentalDays;
    private LocalDate issuedDate;
    private LocalTime issuedTime;

    private String totalCharge;
    private String customerPaidStatus;
}
