package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.TodoDTO;
import com.lms.university.LearningManagementSystem.dto.response.TodoIdResponseDTO;
import com.lms.university.LearningManagementSystem.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface TodoMappers {


    TodoIdResponseDTO EntityToDto(Optional<Todo> todo);
}
