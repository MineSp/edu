package com.edu_b.edu_b.repository;
import com.edu_b.edu_b.entity.Indexdb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IndexdbRepository extends JpaRepository<Indexdb, Integer> {
    /**
     * 数据访问层--指标库
     */
    Optional<Indexdb> findByContent(String content);
}
