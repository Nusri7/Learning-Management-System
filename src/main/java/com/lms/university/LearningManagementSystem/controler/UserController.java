package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.service.UserService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
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

}
