package com.lms.university.LearningManagementSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSaveRequestDTO {
    private String name;
    private String email;
    private String password;
    private boolean activeState;

    
}
