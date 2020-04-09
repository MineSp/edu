package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface StuRepository extends JpaRepository<Stu, BigInteger> {
    /**
     * 数据访问层--学生
     */

    Optional<Stu> findByStudentid(long student);
}
