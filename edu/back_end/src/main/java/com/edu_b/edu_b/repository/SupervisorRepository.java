package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Supervisor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SupervisorRepository extends JpaRepository<Supervisor ,Integer> {
    /**
     * 数据访问层--督导员
     */
    Optional<Supervisor> findBySupervisorid(long supervisorid);
}
