package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepository extends JpaRepository<College, Integer> {
    /**
     * 数据访问层--学院
     */

    /**
     *
     * @param collegeid
     * @return
     */
    Optional<College>  findByCollegeid(long collegeid);
}
