package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    void addTodo(TodoDTO todoDTO);

    List<TodoDTO> getTodos(int id);
}
