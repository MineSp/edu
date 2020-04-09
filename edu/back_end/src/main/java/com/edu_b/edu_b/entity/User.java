package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class User {
    /**
     * 实体类--用户
     *  id          int     用户序号
     *  useraccount long    用户账号
     *  username    String  用户名字
     *  password    String  用户密码
     *  id_id       int     身份标识（管理员-1 ，学生0 ，教师1，督导员2
     *  img         String  用户头像
     *  isLogini    int     用户是否处于登录状态
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long useraccount;
    private String username;
    private String password;
    private int id_id;
    private String img;
    private int islogin;
}
