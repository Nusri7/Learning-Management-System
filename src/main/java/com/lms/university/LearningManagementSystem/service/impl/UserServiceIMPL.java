package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserNameUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserPasswordUpdateDTO;
import com.lms.university.LearningManagementSystem.entity.User;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.UserRepo;
import com.lms.university.LearningManagementSystem.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public UserDTO userById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
            return userDTO;
        }
        throw new NotFoundException("User not found for this ID!!");
    }

    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUserId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.isActiveState());

        if(!userRepo.existsById(user.getUserId())){
            userRepo.save(user);
            return user.getName() + " Saved";
        }

        throw new EntryDuplicateException("User already exist!!");
    }

    @Override
    public void removeUser(int id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public void updateUserName(UserNameUpdateRequestDTO userNameUpdateRequestDTO) {
        if(userRepo.existsById(userNameUpdateRequestDTO.getUserId())){
            userRepo.updateUserName(userNameUpdateRequestDTO.getName(), userNameUpdateRequestDTO.getUserId());

        }else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public void updatePassword(UserPasswordUpdateDTO userPasswordUpdateDTO) {
        if(userRepo.existsById(userPasswordUpdateDTO.getUserId())){
            userRepo.updatePassword(userPasswordUpdateDTO.getPassword(),userPasswordUpdateDTO.getUserId());
        }else {
            throw new NotFoundException("User not found");
        }
    }
}
