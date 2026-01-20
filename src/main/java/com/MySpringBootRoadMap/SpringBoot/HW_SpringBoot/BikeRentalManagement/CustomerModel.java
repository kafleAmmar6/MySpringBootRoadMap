package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.BikeRentalManagement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="RENTAL ISSUE")
public class CustomerModel {

    @Id
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String issueBikeModel;
    private String issueBikeBrand;
    private String issueBikeCc;
    private String customerTotalRentalCharges;
}
