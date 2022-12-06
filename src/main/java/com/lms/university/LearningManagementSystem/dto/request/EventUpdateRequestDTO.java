package com.lms.university.LearningManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EventUpdateRequestDTO {
    private int eventId;
    private String mainTitle;
    private String subTitle;
    private String description;
    private String startTime;
    private String endTime;
    private String month;
    private String day;
    private String eventLink;
}
