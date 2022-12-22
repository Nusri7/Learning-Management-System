package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {
    void addNotification(NotificationDTO notificationDTO);

    List<NotificationDTO> getNotifications();
}
