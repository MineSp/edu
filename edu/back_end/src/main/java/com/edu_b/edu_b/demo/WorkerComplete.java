package com.edu_b.edu_b.demo;

import lombok.Data;

@Data
public class WorkerComplete  {
    /**
     * 实体类--教师
     * id           int     教师序号
     * workerid     long    教师工号
     * name         String  名字
     * sex          String  性别
     * age          int     年龄
     * phone        long    手机号
     * email        String  邮箱
     * id_college   long    所属学院
     * edu          String  学历
     */
    private int id;
    private long workerid;
    private String name = "jack";
    private String sex = "男";
    private int age = 18;
    private String email = "1111111111@qq.com";
    private long id_college = 1;
    private String collegename;
    private String edu;
}
