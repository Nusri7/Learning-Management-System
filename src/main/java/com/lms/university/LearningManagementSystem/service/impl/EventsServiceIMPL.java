package com.lms.university.LearningManagementSystem.service.impl;


import com.lms.university.LearningManagementSystem.dto.EventDTO;
import com.lms.university.LearningManagementSystem.dto.request.EventUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.entity.Events;
import com.lms.university.LearningManagementSystem.entity.User;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.EventsRepo;
import com.lms.university.LearningManagementSystem.service.EventsService;
import com.lms.university.LearningManagementSystem.utill.mappers.EventsMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceIMPL implements EventsService {
    @Autowired
    private EventsRepo eventsRepo;

    @Autowired
    private EventsMappers eventsMappers;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addEvent(EventDTO eventDTO) {
        Events events = modelMapper.map(eventDTO, Events.class);
        if (!eventsRepo.existsById(events.getEventId())) {
                eventsRepo.save(events);
        }else{
            throw new EntryDuplicateException("Duplicated id");
        }
    }

    @Override
    public String updateEvent(EventUpdateRequestDTO eventUpdateRequestDTO) {
        if(eventsRepo.existsById(eventUpdateRequestDTO.getEventId())){
            eventsRepo.updateEvent(eventUpdateRequestDTO.getMainTitle(), eventUpdateRequestDTO.getSubTitle(), eventUpdateRequestDTO.getDescription(), eventUpdateRequestDTO.getStartTime(), eventUpdateRequestDTO.getEndTime(), eventUpdateRequestDTO.getMonth(), eventUpdateRequestDTO.getDay(),eventUpdateRequestDTO.getEventLink(), eventUpdateRequestDTO.getEventId());
            return eventUpdateRequestDTO.getEventId()+ " Successfully updated";
        }else {
            throw new NotFoundException("User not found");
        }


    }

    @Override
    public List<EventDTO> getEvents() {
        List<Events> getEvents = eventsRepo.findAll();
        return eventsMappers.listEntityToListDto(getEvents);

    }
}
