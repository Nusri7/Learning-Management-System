package com.lms.university.LearningManagementSystem.service.impl;


import com.lms.university.LearningManagementSystem.dto.TodoDTO;
import com.lms.university.LearningManagementSystem.dto.response.TodoIdResponseDTO;
import com.lms.university.LearningManagementSystem.entity.Todo;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.TodoRepo;
import com.lms.university.LearningManagementSystem.repository.UserRepo;
import com.lms.university.LearningManagementSystem.service.TodoService;
import com.lms.university.LearningManagementSystem.utill.mappers.TodoMappers;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceIMPL implements TodoService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private TodoMappers todoMappers;

    @Override
    public void removeTodo(int id) {
        if(todoRepo.existsById(id)){
            todoRepo.deleteById(id);
        } else {
            throw new NotFoundException("Todo not found");
        }
    }

    @Override
    public TodoIdResponseDTO getLastTodo() {
        if(!todoRepo.findAll().isEmpty()){

            System.out.println(todoRepo.lastTodoId());
            return null;
        }else {
            throw new NotFoundException("Data not found");
        }
    }

    @Override
    public void addTodo(TodoDTO todoDTO) {
       /* Todo todo = modelMapper.map(todoDTO, Todo.class);
        if(todoRepo.existsById(todo.getTodoId())){
            todoRepo.save(todo);
        }else{
            throw new EntryDuplicateException("Id already exists");
        }*/
        Todo todo = new Todo(
                todoDTO.getTodoId(),
                todoDTO.getTodoName(),
                userRepo.getById(todoDTO.getUser())
        );
        todoRepo.save(todo);
    }

    @Override
    public List<TodoDTO> getTodos(int id) {
        List<Todo> todo = todoRepo.findAllByUserUserIdEquals(id);

        if(!todo.isEmpty()){
            /*List<TodoDTO> todoDTOS = todoMappers.listEntityToListDto(todo);*/
            List<TodoDTO> todoDTOS = modelMapper.
                    map(todo, new TypeToken<List<TodoDTO>>() {
                    }.getType());
            return todoDTOS;
        }
        else{
            throw new NotFoundException("No Data");
        }
    }
}
