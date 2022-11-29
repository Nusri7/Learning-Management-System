package com.lms.university.LearningManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RecordingDTO {
    private int recording_id;
    private String title;
    private String subject;
    private String recordingLink;
}
