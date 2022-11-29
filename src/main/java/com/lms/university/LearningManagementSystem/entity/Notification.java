package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notification_id", length= 40)
    private int notificationId;

    @Column(name = "sender_name", length = 40, nullable = false)
    private String senderName;

    @Column(name = "message", length = 500, nullable = false)
    private String message;

    @Column(name = "sender_image_path", length = 500, nullable = true)
    private String senderImagePath;
}
