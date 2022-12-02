package com.lms.university.LearningManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserNameUpdateRequestDTO {
    private int userId;
    private String name;
}
