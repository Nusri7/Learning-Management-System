package com.lms.university.LearningManagementSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", length = 40)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "name", length = 40, nullable=false)
    private String name;

    @Column(name = "email", length = 40, nullable=false, unique = true)
    private String email;

    @Column(name = "password", length = 40, nullable=false)
    private String password;

    @Column(name = "active_state", length = 40, columnDefinition = "TINYINT default 0")
    private boolean activeState;

}
