package com.edu_b.edu_b.demo;

import lombok.Data;

@Data
public class PersonalCenter {
    /**
     * 伪实体类--用户个人中心
     */
    private long useraccount;
    private String username;
    private String id_idname;
//    private String img;
    private String sex;
    private int age;
    private String email;
    private String classname ="";
    private String specname ="";
    private String collegename ="";
    private  String edu ="";
}
