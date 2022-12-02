package com.lms.university.LearningManagementSystem.service.impl;


import com.lms.university.LearningManagementSystem.entity.User;
import com.lms.university.LearningManagementSystem.repository.EventsRepo;
import com.lms.university.LearningManagementSystem.service.EventsService;
import com.lms.university.LearningManagementSystem.utill.mappers.EventsMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventsServiceIMPL implements EventsService {
    @Autowired
    private EventsRepo eventsRepo;

    @Autowired
    private ModelMapper modelMapper;




}
