package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Integer> {

    @Modifying
    @Query(value = "update user set name =?1 where user_id =?2",nativeQuery = true)
    void updateUserName(String name, int id);

    @Modifying
    @Query(value = "update user set password=?1 where user_id =?2",nativeQuery = true)
    void updatePassword(String password, int userId);
}
