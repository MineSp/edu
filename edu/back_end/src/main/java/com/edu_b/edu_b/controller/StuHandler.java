package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.entity.Stu;
import com.edu_b.edu_b.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StuHandler {
    @Autowired
    private StuRepository stuRepository;
    @GetMapping("/findAll")
    public List<Stu> findAll(){

        return  stuRepository.findAll();
    }
}
