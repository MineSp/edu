package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class Indexdb {
    /**
     * 指标库实体
     * id       int     指标库序号
     * content  String  指标库内容
     * open     int     是否启用
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;
    private int open;
}
