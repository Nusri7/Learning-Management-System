package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface EventsRepo extends JpaRepository<Events,Integer> {
    @Modifying
    @Query(value = "update events set main_title =?1, sub_title= ?2, description =?3, start_time =?4, end_time= ?5, month= ?6, day =?7, event_link =?8 where event_id =?9",nativeQuery = true)
    void updateEvent(String mainTitle, String subTitle, String description, String startTime, String endTime, String month, String day, String eventLink, int eventId);
}
