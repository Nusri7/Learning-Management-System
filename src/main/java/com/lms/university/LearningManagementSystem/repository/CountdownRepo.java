package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.Countdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CountdownRepo extends JpaRepository<Countdown,Integer> {
}
