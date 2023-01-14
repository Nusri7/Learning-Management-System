package com.lms.university.LearningManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStateUpdateDTO {
    private int userId;
    private boolean activeState;
}
