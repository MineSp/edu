package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;


@Entity
@Data
public class Stu {
    /**
     * 实体类--学生
     * id           int     学生序号
     * studentid    long    学号
     * name         string  学生姓名
     * sex          String  学生性别
     * age          int     学生年龄
     * email        String  学生邮箱
     * id_class     int     学生所属班级
     * id_spec      long    学生所属专业
     * id_college   long    学生所属学院
     */

    @Id
    private int id;
    private long studentid;
    private String name;
    private String sex;
    private Integer age;
    private String email;
    private int id_class;
    private long id_spec;
    private long id_college;

}
