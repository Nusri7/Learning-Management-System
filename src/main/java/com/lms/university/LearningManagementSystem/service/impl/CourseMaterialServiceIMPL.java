package com.lms.university.LearningManagementSystem.service.impl;


import com.lms.university.LearningManagementSystem.repository.CourseMaterialRepo;
import com.lms.university.LearningManagementSystem.service.CourseMaterialService;
import com.lms.university.LearningManagementSystem.utill.mappers.CourseMaterialMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMaterialServiceIMPL implements CourseMaterialService {
    @Autowired
    private CourseMaterialRepo courseMaterialRepo;

    @Autowired
    private ModelMapper modelMapper;


}
