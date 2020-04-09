package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class College {
    /**
     * 实体类--学院
     * id           int     学院序号
     * collegeid    long    学院号
     * name         String  学院名字
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long collegeid;
    private String name;

}
