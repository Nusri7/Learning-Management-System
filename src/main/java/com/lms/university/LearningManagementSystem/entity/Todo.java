package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Table(name = "todo")
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "todo_id", length = 40)
    private int todoId;

    @Column(name = "todo_name", nullable = false)
    private String todoName;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;


}
