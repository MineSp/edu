package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@Data
public class Course {
    /**
     * 实体类--课程
     * id           int             课程序号
     * courseid     long            课程号
     * name         String          课程名字
     * type         int             课程类型（0必修、1选修）
     * time_start   java.sql.Date   课程开设时间
     * id_college   long            开设学院
     * id_worker    long            任课老师
     * addr         String          上课地点
     * time_week    java.sql.Date   上课时间
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long courseid;
    private String name;
    private int type;
    private Date time_start;
    private long id_college;
    private long id_worker;
    private String addr;
    private String time_week;
}
