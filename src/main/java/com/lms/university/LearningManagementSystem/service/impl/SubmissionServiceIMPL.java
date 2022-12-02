package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.repository.SubmissionRepo;
import com.lms.university.LearningManagementSystem.service.SubmissionService;
import com.lms.university.LearningManagementSystem.utill.mappers.SubmissionMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubmissionServiceIMPL implements SubmissionService {
    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private ModelMapper modelMapper;


}
