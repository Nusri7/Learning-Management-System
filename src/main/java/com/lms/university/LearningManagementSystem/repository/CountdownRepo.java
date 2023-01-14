package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.Countdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface CountdownRepo extends JpaRepository<Countdown,Integer> {

    @Modifying
    @Query(value = "update countdown set day =?1, month =?2, year =?3, event_name =?4  where countdown_id =?5",nativeQuery = true)
    void updateCountdown(int day, String month, int year, String eventName, int countdownId);
}
