package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, Integer> {
    /**
     * 数据访问层--班级
     */

}
