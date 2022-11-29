package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.Recordings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RecordingsRepo extends JpaRepository<Recordings,Integer> {
}
