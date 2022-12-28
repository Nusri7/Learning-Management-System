package com.lms.university.LearningManagementSystem.controler;


import com.lms.university.LearningManagementSystem.dto.TodoDTO;
import com.lms.university.LearningManagementSystem.dto.response.TodoIdResponseDTO;
import com.lms.university.LearningManagementSystem.service.TodoService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("api/v1/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping(path = "/add-todo")
    public ResponseEntity<StandardResponse> addTodo(@RequestBody TodoDTO todoDTO){
        todoService.addTodo(todoDTO);

        return  new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Successfully added",todoDTO), HttpStatus.CREATED
        );
    }
    @GetMapping(path="/get-todo/{id}")
    public ResponseEntity<StandardResponse> getTodos(@PathVariable(value = "id") int id) {
        List<TodoDTO> todoDTOS = todoService.getTodos(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", todoDTOS), HttpStatus.OK
        );
    }

    @DeleteMapping(path = "/delete-todo/{id}")
    public ResponseEntity<StandardResponse> removeTodo(@PathVariable(value = "id") int id){
        todoService.removeTodo(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted!!",null),HttpStatus.OK
        );

    }

    @GetMapping(path="/get-last-todo")
    public ResponseEntity<StandardResponse> getLastTodo() {
        TodoIdResponseDTO todoDTO = todoService.getLastTodo();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200, "success", todoDTO), HttpStatus.OK
        );
    }

}
