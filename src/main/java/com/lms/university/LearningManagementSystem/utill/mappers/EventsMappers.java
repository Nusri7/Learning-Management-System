package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.EventDTO;
import com.lms.university.LearningManagementSystem.entity.Events;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventsMappers {

    List<EventDTO> listEntityToListDto(List<Events> getEvents);
}
