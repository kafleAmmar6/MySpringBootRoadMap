package com.MySpringBootRoadMap.SpringBoot.HW_SpringBoot.StudentResult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor

    public class Student {

        //Student Detail of School
        @MongoId
        private Integer studentRollNumber;
        private String studentName;
        private String studentClassLevel;

        //Student Subject Marks
        private Double studentEconomicMarks;
        private Double  studentAccountMarks;
        private Double  studentEnglishMarks;
        private Double  studentNepaliMarks;
        private Double studentMathMarks;
        private Double  studentComputerMarks;

        //School and Student Examination Deal
        private Double studentTotalMarks;
        private Double studentPassMarks;
        private Double studentObtainedMarks;

        //Student Result
        private String studentResult;

    }

