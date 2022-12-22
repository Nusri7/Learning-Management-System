package com.lms.university.LearningManagementSystem.utill.mappers;

import com.lms.university.LearningManagementSystem.dto.SubmissionDTO;
import com.lms.university.LearningManagementSystem.entity.Submission;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubmissionMappers {

    List<SubmissionDTO> listEntityToListDto(List<Submission> getSubmissions);
}
