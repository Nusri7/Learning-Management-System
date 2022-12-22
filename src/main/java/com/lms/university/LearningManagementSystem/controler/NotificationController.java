package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.EventDTO;
import com.lms.university.LearningManagementSystem.dto.NotificationDTO;
import com.lms.university.LearningManagementSystem.service.EventsService;
import com.lms.university.LearningManagementSystem.service.NotificationService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/notification")
@CrossOrigin("http://localhost:3000")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    @PostMapping(path="/add-notification")
    public ResponseEntity<StandardResponse> addNotification(@RequestBody NotificationDTO notificationDTO){
        notificationService.addNotification(notificationDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully added event",null), HttpStatus.CREATED
        );
    }
    @GetMapping(path="/get-notifications")
    public ResponseEntity<StandardResponse> getNotifications(){
        List<NotificationDTO> notificationDTOList = notificationService.getNotifications();

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"success",notificationDTOList), HttpStatus.OK
        );
    }
}
