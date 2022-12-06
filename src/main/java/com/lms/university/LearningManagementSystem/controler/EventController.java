package com.lms.university.LearningManagementSystem.controler;

import com.lms.university.LearningManagementSystem.dto.EventDTO;

import com.lms.university.LearningManagementSystem.dto.request.EventUpdateRequestDTO;
import com.lms.university.LearningManagementSystem.service.EventsService;
import com.lms.university.LearningManagementSystem.utill.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/event")
@CrossOrigin("http://localhost:3000/")
public class EventController {

    @Autowired
    private EventsService eventsService;

    @PostMapping(path="/add-event")
    public ResponseEntity<StandardResponse> addEvent(@RequestBody EventDTO eventDTO){
        eventsService.addEvent(eventDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully added event",null), HttpStatus.CREATED
        );
    }

    @PutMapping(path="/update-event")
    public ResponseEntity<StandardResponse> updateEvent(@RequestBody EventUpdateRequestDTO eventUpdateRequestDTO){
        String id = eventsService.updateEvent(eventUpdateRequestDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"successfully updated event",id), HttpStatus.OK
        );
    }
}
