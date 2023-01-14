package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserNameUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserPasswordUpdateDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserSaveRequestDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserStateUpdateDTO;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.service.UserService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(path = "/get-user-by-email", params = "email")
    public ResponseEntity<StandardResponse> getUserByEmail(@RequestParam(value = "email") String email){
        UserDTO userDTO = userService.userByEmail(email);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"OK", userDTO), HttpStatus.OK
        );
    }
    @GetMapping(path = "/get-user-by-id-password", params = {"email","pwd"})
    public ResponseEntity<StandardResponse> getUserByIdPassword(@RequestParam(value = "email") String email, String pwd){
        String found = userService.userByIdPassword(email, pwd);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"OK", found), HttpStatus.OK
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

    @GetMapping(path = "/get-state-by-opinion/{state}")
    public ResponseEntity<StandardResponse> getUsersByState(@PathVariable(value = "state")  String state) throws NotFoundException {
        List<UserDTO> userDTOS = userService.getUsersByState(state);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"",userDTOS),HttpStatus.OK
        );
    }

    @PutMapping(path = "/update-active-state")
    public ResponseEntity<StandardResponse> updateUserName(@RequestBody UserStateUpdateDTO userStateUpdateDTO){
        userService.updateUserState(userStateUpdateDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated!!",null),HttpStatus.OK
        );
    }

}
