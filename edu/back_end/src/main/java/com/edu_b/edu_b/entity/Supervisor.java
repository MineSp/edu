package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Supervisor {

    /**
     * 督导员--实体类
     * id               int     督导员序号
     * supervisorid     long    督导员工号
     * name             String  督导员名字
     * sex              String  性别
     * age              int     年龄
     * id_college       long    所属学院
     * email            String  邮箱
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long supervisorid;
    private String name;
    private String sex;
    private int age;
    private long id_college;
    private String email;
}
