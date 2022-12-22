package com.lms.university.LearningManagementSystem.service.impl;

import com.lms.university.LearningManagementSystem.dto.SubmissionDTO;
import com.lms.university.LearningManagementSystem.entity.Notification;
import com.lms.university.LearningManagementSystem.entity.Submission;
import com.lms.university.LearningManagementSystem.exceptions.EntryDuplicateException;
import com.lms.university.LearningManagementSystem.repository.SubmissionRepo;
import com.lms.university.LearningManagementSystem.service.SubmissionService;
import com.lms.university.LearningManagementSystem.utill.mappers.NotificationMappers;
import com.lms.university.LearningManagementSystem.utill.mappers.SubmissionMappers;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceIMPL implements SubmissionService {
    @Autowired
    private SubmissionRepo submissionRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SubmissionMappers submissionMappers;


    @Override
    public void addSubmission(SubmissionDTO submissionDTO) {
        Submission submission = modelMapper.map(submissionDTO, Submission.class);
        if (!submissionRepo.existsById(submission.getSubmissionId())) {
            submissionRepo.save(submission);
        }else{
            throw new EntryDuplicateException("Duplicated id");
        }
    }

    @Override
    public List<SubmissionDTO> getSubmissions() {
        List<Submission> getSubmissions = submissionRepo.findAll();
        return submissionMappers.listEntityToListDto(getSubmissions);
    }

}
