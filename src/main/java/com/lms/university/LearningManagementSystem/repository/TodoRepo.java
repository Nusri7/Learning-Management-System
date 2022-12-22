package com.lms.university.LearningManagementSystem.repository;


import com.lms.university.LearningManagementSystem.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TodoRepo extends JpaRepository<Todo,Integer> {


    List<Todo> findAllByUserUserIdEquals(int id);

    List<Todo> findAllByTodoIdEquals(int id);


}
