package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.SubmissionDTO;

import java.util.List;

public interface SubmissionService {
    void addSubmission(SubmissionDTO submissionDTO);

    List<SubmissionDTO> getSubmissions();
}
