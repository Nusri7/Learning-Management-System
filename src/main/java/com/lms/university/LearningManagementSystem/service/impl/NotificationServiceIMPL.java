package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.repository.NotificationRepo;
import com.lms.university.LearningManagementSystem.service.NotificationService;
import com.lms.university.LearningManagementSystem.utill.mappers.NotificationMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceIMPL implements NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NotificationMappers notificationMappers;
}
