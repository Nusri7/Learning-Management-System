package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.NotificationDTO;
import com.lms.university.LearningManagementSystem.entity.Notification;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationMappers {
    List<NotificationDTO> listEntityToListDto(List<Notification> getNotifications);
}
