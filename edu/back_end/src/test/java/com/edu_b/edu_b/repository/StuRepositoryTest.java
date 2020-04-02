package com.edu_b.edu_b.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StuRepositoryTest {

    @Autowired
    private StuRepository stuRepository;

    @Test
    void findAll(){
        System.out.println(stuRepository.findAll());
    }
}