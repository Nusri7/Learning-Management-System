package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserNameUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserPasswordUpdateDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserSaveRequestDTO;
import com.lms.university.LearningManagementSystem.service.UserService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin("http://localhost:3000/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/get-user-by-id", params = "id")
    public ResponseEntity<StandardResponse> getUserById(@RequestParam(value = "id") int id){
        UserDTO userDTO = userService.userById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"OK", userDTO), HttpStatus.OK
        );
    }

    @PostMapping(path="/add-user")
    public ResponseEntity<StandardResponse> addUser(@RequestBody UserDTO userDTO){
        String id =  userService.addUser(userDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"success",id), HttpStatus.CREATED
        );
    }

    @DeleteMapping(path = "/delete-user/{id}")
    public ResponseEntity<StandardResponse> removeUser(@PathVariable(value = "id") int id){
        userService.removeUser(id);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Deleted!!",null),HttpStatus.OK
        );

    }

    @PutMapping(path = "/update-user-name")
    public ResponseEntity<StandardResponse> updateUserName(@RequestBody UserNameUpdateRequestDTO userNameUpdateRequestDTO){
        userService.updateUserName(userNameUpdateRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated!!",null),HttpStatus.OK
        );
    }

    @PutMapping(path = "/update-password")
    public ResponseEntity<StandardResponse> updatePassword(@RequestBody UserPasswordUpdateDTO userPasswordUpdateDTO){
        userService.updatePassword(userPasswordUpdateDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated!!",null),HttpStatus.OK
        );
    }

}
