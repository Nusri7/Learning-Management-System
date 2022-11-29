package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Countdown {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countdown_id", length = 40)
    private int countdown;

    @Column(name = "days", nullable = false)
    private int days;

    @Column(name = "hours", nullable = false)
    private int hours;

    @Column(name = "minutes", nullable = false)
    private int minutes;
}
