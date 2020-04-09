package com.edu_b.edu_b.repository;
import com.edu_b.edu_b.entity.Spec;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpecRepository extends JpaRepository<Spec, Integer> {
    /**
     * 数据访问层--专业
     */

    Optional<Spec> findBySpecid(long specid);
}
