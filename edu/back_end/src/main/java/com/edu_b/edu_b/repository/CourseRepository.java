package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    /**
     * 数据访问层--课程
     */
}
