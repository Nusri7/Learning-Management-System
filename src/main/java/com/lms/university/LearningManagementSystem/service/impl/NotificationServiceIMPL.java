package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.EventDTO;
import com.lms.university.LearningManagementSystem.dto.NotificationDTO;
import com.lms.university.LearningManagementSystem.entity.Events;
import com.lms.university.LearningManagementSystem.entity.Notification;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.repository.NotificationRepo;
import com.lms.university.LearningManagementSystem.service.NotificationService;
import com.lms.university.LearningManagementSystem.utill.mappers.NotificationMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceIMPL implements NotificationService {
    @Autowired
    private NotificationRepo notificationRepo;

    @Autowired
    private NotificationMappers notificationMappers;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addNotification(NotificationDTO notificationDTO) {
        Notification notification = modelMapper.map(notificationDTO, Notification.class);
        if (!notificationRepo.existsById(notification.getNotificationId())) {
            notificationRepo.save(notification);
        }else{
            throw new EntryDuplicateException("Duplicated id");
        }
    }

    @Override
    public List<NotificationDTO> getNotifications() {

        List<Notification> getNotifications = notificationRepo.findAll();
        return notificationMappers.listEntityToListDto(getNotifications);

    }
}
