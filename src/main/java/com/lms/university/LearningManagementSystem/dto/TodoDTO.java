package com.lms.university.LearningManagementSystem.dto;

import com.lms.university.LearningManagementSystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data


public class TodoDTO {
    private int todoId;
    private String todoName;
    private int user;
}