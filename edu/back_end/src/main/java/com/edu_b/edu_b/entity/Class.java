package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Class {
    /**
     * 实体类--班级
     * id           int     班级序号
     * name         String  班级名字
     * id_college   long    班级所属学院号
     * id_worker    long    班主任工号
     * id_spec      long    专业号
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long id_college;
    private long id_worker;
    private long id_spec;

}
