package com.lms.university.LearningManagementSystem.service;

import com.lms.university.LearningManagementSystem.dto.CountDownDTO;

public interface CountdownService {
    void addCountdown(CountDownDTO countDownDTO);

    CountDownDTO getCountDownById(int id);
}
