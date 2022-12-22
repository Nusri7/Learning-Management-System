package com.lms.university.LearningManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountDownDTO {
    private int countdownId;
    private String eventName;
    private int day;
    private String month;
    private int year;

}
