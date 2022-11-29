package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cm_id", length =40)
    private int cm_id;

    @Column(name = "subject", length =50, nullable = true)
    private String subject;

    @Column(name = "title", length =60, nullable = false)
    private String title;

    @Column(name = "cm_path", length = 500, nullable = true)
    private String cmPath;
}
