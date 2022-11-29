package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Recordings {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recording_id", length =40)
    private int recording_id;

    @Column(name = "title", length =60, nullable = false)
    private String title;

    @Column(name = "subject", length =50, nullable = true)
    private String subject;

    @Column(name = "recording_link", length = 500, nullable = true)
    private String recordingLink;


}
