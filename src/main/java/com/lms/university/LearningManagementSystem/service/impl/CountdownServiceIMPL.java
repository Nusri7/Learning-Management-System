package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.repository.CountdownRepo;
import com.lms.university.LearningManagementSystem.service.CountdownService;
import com.lms.university.LearningManagementSystem.utill.mappers.CountdownMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountdownServiceIMPL implements CountdownService {
    @Autowired
    private CountdownRepo countdownRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CountdownMappers countdownMappers;
}
