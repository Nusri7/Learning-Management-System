package com.lms.university.LearningManagementSystem.repository;


import com.lms.university.LearningManagementSystem.dto.response.TodoIdResponseDTO;
import com.lms.university.LearningManagementSystem.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
@Transactional
public interface TodoRepo extends JpaRepository<Todo,Integer> {
    List<Todo> findAllByUserUserIdEquals(int id);


    @Modifying
    @Query(value = "select * from todo order by todo_id DESC",nativeQuery = true)
    int lastTodoId();

}


