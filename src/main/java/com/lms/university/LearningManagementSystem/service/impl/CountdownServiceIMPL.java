package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.CountDownDTO;
import com.lms.university.LearningManagementSystem.dto.UserDTO;
import com.lms.university.LearningManagementSystem.entity.Countdown;
import com.lms.university.LearningManagementSystem.entity.User;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.CountdownRepo;
import com.lms.university.LearningManagementSystem.service.CountdownService;
import com.lms.university.LearningManagementSystem.utill.mappers.CountdownMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountdownServiceIMPL implements CountdownService {
    @Autowired
    private CountdownRepo countdownRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addCountdown(CountDownDTO countDownDTO) {
        Countdown countdown = modelMapper.map(countDownDTO, Countdown.class);
        if(countdownRepo.existsById(countdown.getCountdownId())){
            countdownRepo.save(countdown);
        }else{
            throw new EntryDuplicateException("Id already exists");
        }
    }

    @Override
    public CountDownDTO getCountDownById(int id) {
        Optional<Countdown> countdown = countdownRepo.findById(id);
        if (countdown.isPresent()) {
            return modelMapper.map(countdown.get(), CountDownDTO.class);
        }
        throw new NotFoundException("User not found for this ID!!");
    }

}
