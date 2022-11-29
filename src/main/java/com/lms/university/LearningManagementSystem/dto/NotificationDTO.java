package com.lms.university.LearningManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {
    private int notificationId;
    private String senderName;
    private String message;
    private String senderImagePath;
}
