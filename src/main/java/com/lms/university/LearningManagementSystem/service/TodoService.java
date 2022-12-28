package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.TodoDTO;
import com.lms.university.LearningManagementSystem.dto.response.TodoIdResponseDTO;

import java.util.List;

public interface TodoService {
    

    void addTodo(TodoDTO todoDTO);

    List<TodoDTO> getTodos(int id);

    void removeTodo(int id);

    TodoIdResponseDTO getLastTodo();
}
