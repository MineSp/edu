package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Stu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface StuRepository extends JpaRepository<Stu, BigInteger> {
}
