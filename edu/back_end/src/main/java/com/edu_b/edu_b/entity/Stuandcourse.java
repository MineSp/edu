package com.edu_b.edu_b.entity;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Stuandcourse {
    /**
     * 实体类--学生课程关系表
     * id           int     序号
     * id_stu       long    学生学号
     * id_course    long    课程号
     * score        int     分数
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long id_stu;
    private long id_course;
    private int score;

}
