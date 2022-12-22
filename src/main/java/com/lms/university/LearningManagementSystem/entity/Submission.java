package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "submission_id", length = 40)
    private int submissionId;

    @Column(name = "title", length =60, nullable = false)
    private String title;

    @Column(name = "description", length =80, nullable = true)
    private String description;

    @Column(name = "submission_link", length =500, nullable = true)
    private String submissionLink;
}
