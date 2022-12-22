package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.TodoDTO;
import com.lms.university.LearningManagementSystem.entity.Todo;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TodoMappers {
    List<TodoDTO> listEntityToListDto(List<Todo> getTodos);
}
