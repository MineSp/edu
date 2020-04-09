package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Spec {
    /**
     * 专业——实体类
     *  id          int     专业序号
     *  specid      Bigint  专业号
     *  name        varchar 专业名字
     *  id_college  Bigint  所属学院
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long specid;
    private String name;
    private int id_college;
}
