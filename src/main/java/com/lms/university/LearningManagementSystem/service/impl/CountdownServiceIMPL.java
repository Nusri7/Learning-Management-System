package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.CountDownDTO;
import com.lms.university.LearningManagementSystem.entity.Countdown;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.exceptions.NotFoundException;
import com.lms.university.LearningManagementSystem.repository.CountdownRepo;
import com.lms.university.LearningManagementSystem.service.CountdownService;
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
        if(!countdownRepo.existsById(countdown.getCountdownId())){
            countdownRepo.save(countdown);
        }else{
            throw new EntryDuplicateException("Id already exists");
        }
    }

    @Override
    public String getCountDownById(int id) {
        Optional<Countdown> countdown = countdownRepo.findById(id);
        if (countdown.isPresent()) {
            return countdown.get().getMonth() + "," + countdown.get().getDay() + "," + countdown.get().getYear();
        }
        throw new NotFoundException("User not found for this ID!!");
    }

    @Override
    public CountDownDTO getCountDownByDTOId(int id) {
        Optional<Countdown> countdown = countdownRepo.findById(id);
        if (countdown.isPresent()) {
            return modelMapper.map(countdown.get(), CountDownDTO.class);
        }
        throw new NotFoundException("User not found for this ID!!");
    }

    @Override
    public void updateCountdown(CountDownDTO countDownDTO) {
        if(countdownRepo.existsById(countDownDTO.getCountdownId())){
            countdownRepo.updateCountdown(countDownDTO.getDay(),countDownDTO.getMonth(),countDownDTO.getYear(), countDownDTO.getEventName(),countDownDTO.getCountdownId());

        }else {
            throw new NotFoundException("User not found");
        }
    }

}
