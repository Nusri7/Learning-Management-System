package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.repository.RecordingsRepo;
import com.lms.university.LearningManagementSystem.service.RecordingsService;
import com.lms.university.LearningManagementSystem.utill.mappers.RecordingsMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordingsServiceIMPL implements RecordingsService {
    @Autowired
    private RecordingsRepo recordingsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecordingsMappers recordingsMappers;
}
