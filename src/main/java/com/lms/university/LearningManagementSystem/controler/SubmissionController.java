package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.NotificationDTO;
import com.lms.university.LearningManagementSystem.dto.SubmissionDTO;
import com.lms.university.LearningManagementSystem.service.SubmissionService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/submission")
@CrossOrigin("http://localhost:3000")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @PostMapping(path="/add-submission")
    public ResponseEntity<StandardResponse> addSubmission(@RequestBody SubmissionDTO submissionDTO){
        submissionService.addSubmission(submissionDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully added submission",null), HttpStatus.CREATED
        );
    }

    @GetMapping(path="/get-submissions")
    public ResponseEntity<StandardResponse> getNotifications(){
        List<SubmissionDTO> submissionDTOList = submissionService.getSubmissions();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",submissionDTOList), HttpStatus.OK
        );
    }
}
