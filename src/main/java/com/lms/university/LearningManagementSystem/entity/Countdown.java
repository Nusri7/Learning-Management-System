package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "countdown")
public class Countdown {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "countdown_id", length = 40)
    private int countdownId;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "day", nullable = false)
    private int day;

    @Column(name = "month", nullable = false)
    private String month;

    @Column(name = "year", nullable = false)
    private int year;
}
