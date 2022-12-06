package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id", length =40)
    private int eventId;

    @Column(name = "main_title", length =60, nullable = false)
    private String mainTitle;

    @Column(name = "sub_title", length =60, nullable = true)
    private String subTitle;

    @Column(name = "description", length =80, nullable = true)
    private String description;

    @Column(name = "start_time", length =10, nullable = true)
    private String startTime;

    @Column(name = "end_time", length =10, nullable = true)
    private String endTime;

    @Column(name = "month", length =20, nullable = false)
    private String month;

    @Column(name = "day", length =20, nullable = false)
    private String day;

    @Column(name = "event_link", length =500, nullable = true)
    private String eventLink;
}
