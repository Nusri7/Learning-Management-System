package com.lms.university.LearningManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubmissionDTO {
    private String submissionId;
    private String title;
    private String description;
    private String submissionLink;
}
