package com.lms.university.LearningManagementSystem.service.impl;


import com.lms.university.LearningManagementSystem.repository.UserRepo;
import com.lms.university.LearningManagementSystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL<UserMappers> implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMappers userMappers;
}
