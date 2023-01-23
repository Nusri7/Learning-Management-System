package com.lms.university.LearningManagementSystem.repository;

import com.lms.university.LearningManagementSystem.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectImageRepo extends JpaRepository<ProductImage, Long> {
    Optional<ProductImage> findByName(String fileName);
}
