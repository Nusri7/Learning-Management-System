package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMappers {
    List<UserDTO> listEntityToListDto(List<User> user);
}
