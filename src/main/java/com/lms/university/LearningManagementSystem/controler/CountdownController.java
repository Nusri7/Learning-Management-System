package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.CountDownDTO;
import com.lms.university.LearningManagementSystem.dto.request.UserStateUpdateDTO;
import com.lms.university.LearningManagementSystem.service.CountdownService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/countdown")
@CrossOrigin("http://localhost:3000/")


public class CountdownController {
    @Autowired
    private CountdownService countdownService;

    @PostMapping(path="/add-countdown")
    public ResponseEntity<StandardResponse> addCountdown(@RequestBody CountDownDTO countDownDTO){
        countdownService.addCountdown(countDownDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully added", null), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-countdown/{id}")
    public ResponseEntity<StandardResponse> getCountDownById(@PathVariable(value = "id") int id){
        String countDown = countdownService.getCountDownById(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully added", countDown), HttpStatus.CREATED
        );
    }

    @GetMapping(path = "/get-countdown-dto/{id}")
    public ResponseEntity<StandardResponse> getCountDownDTOById(@PathVariable(value = "id") int id){
        CountDownDTO countDownDTO = countdownService.getCountDownByDTOId(id);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully added", countDownDTO), HttpStatus.CREATED
        );
    }

    @PutMapping(path = "/update-count-down")
    public ResponseEntity<StandardResponse> updateCountdown(@RequestBody CountDownDTO countDownDTO){
        countdownService.updateCountdown(countDownDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Successfully Updated!!",null),HttpStatus.OK
        );
    }
}
