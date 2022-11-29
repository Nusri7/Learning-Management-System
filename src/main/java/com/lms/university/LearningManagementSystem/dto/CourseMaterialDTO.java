package com.lms.university.LearningManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseMaterialDTO {
    private int cm_id;
    private String subject;
    private String title;
    private String cmPath;
}
