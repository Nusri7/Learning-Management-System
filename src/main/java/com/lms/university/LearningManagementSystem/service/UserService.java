package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserNameUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserPasswordUpdateDTO;


public interface UserService {
    UserDTO userById(int id);

    String addUser(UserDTO userDTO);

    void removeUser(int id);

    void updateUserName(UserNameUpdateRequestDTO userNameUpdateRequestDTO);

    void updatePassword(UserPasswordUpdateDTO userPasswordUpdateDTO);
}
