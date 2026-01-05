package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.AmmarBikeRental;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Bikes")
public class BikeModel {

    @Id
    private String id;

    private String bikeName;

    private boolean issued;
    private boolean availability;

    private String issuedTo;
    private String contactNumber;

    private LocalDateTime issueTime;
    private LocalDateTime returnTime;
}
