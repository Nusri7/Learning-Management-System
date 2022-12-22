package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.EventDTO;
import com.lms.university.LearningManagementSystem.dto.request.EventUpdateRequestDTO;

import java.util.List;

public interface EventsService {
    void addEvent(EventDTO eventDTO);

    String updateEvent(EventUpdateRequestDTO eventUpdateRequestDTO);

    List<EventDTO> getEvents();
}
