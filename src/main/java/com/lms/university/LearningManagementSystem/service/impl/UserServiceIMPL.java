package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserNameUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserPasswordUpdateDTO;

import com.lms.university.LearningManagementSystem.dto.request.UserStateUpdateDTO;
import com.lms.university.LearningManagementSystem.entity.User;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.UserRepo;
import com.lms.university.LearningManagementSystem.service.UserService;

import com.lms.university.LearningManagementSystem.utill.mappers.UserMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserMappers userMappers;



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
        /*User user = new User(
                userDTO.getUserId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.isActiveState());

        if(!userRepo.existsById(user.getUserId())){
            userRepo.save(user);
            return user.getName() + " Saved";
        }
        else {
            throw new EntryDuplicateException("User already exist!!");
        }*/
        User user = modelMapper.map(userDTO, User.class);
        if (!userRepo.existsById(user.getUserId())) {
            userRepo.save(user);
            return user.getName() + " Saved";
        }else{
            throw new EntryDuplicateException("Duplicated id");
        }
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

    @Override
    public String userByIdPassword(String email, String pwd) {
        Optional<User> user = userRepo.findByEmailAndPasswordEqualsAndActiveStateTrue(email, pwd);
        if (user.isPresent()) {
            return "found";
        }else {
            return "not found";
        }

    }

    @Override
    public UserDTO userByEmail(String email) {
        Optional<User> user = userRepo.findByEmailEquals(email);
        if (user.isPresent()) {
            UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
            return userDTO;
        }
        throw new NotFoundException("User not found for this Email!!");
    }

    @Override
    public List<UserDTO> getUsersByState(String state) {
        List<User> user1 = userRepo.findAllByActiveStateEquals(true);
        List<User> user2 = userRepo.findAllByActiveStateEquals(false);
        List<User> user3 = userRepo.findAll();
        if (Objects.equals(state, "active")){
            List<UserDTO> userDTOS = userMappers.listEntityToListDto(user1);
            return userDTOS;
        }else if (state.equals("inactive")){
            List<UserDTO> userDTOS = userMappers.listEntityToListDto(user2);
            return userDTOS;
        }else if(state.equals("all")) {
            List<UserDTO> userDTOS = userMappers.listEntityToListDto(user3);
            return userDTOS;
        }else {
            throw new NotFoundException("Not found");
        }
    }

    @Override
    public void updateUserState(UserStateUpdateDTO userStateUpdateDTO) {
        if(userRepo.existsById(userStateUpdateDTO.getUserId())){
            userRepo.updateUserState(true, userStateUpdateDTO.getUserId());

        }else {
            throw new NotFoundException("User not found");
        }
    }

}
