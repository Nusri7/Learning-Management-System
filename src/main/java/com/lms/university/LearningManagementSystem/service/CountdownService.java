package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.CountDownDTO;

public interface CountdownService {
    void addCountdown(CountDownDTO countDownDTO);

    String getCountDownById(int id);

    CountDownDTO getCountDownByDTOId(int id);

    void updateCountdown(CountDownDTO countDownDTO);
}
