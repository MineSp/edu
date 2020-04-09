package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    /**
     * 数据访问层--教师
     */
    Optional<Worker> findByWorkerid(long workerid);
}
