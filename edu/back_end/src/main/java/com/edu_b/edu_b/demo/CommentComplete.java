package com.edu_b.edu_b.demo;

import lombok.Data;

import java.util.List;

@Data
public class CommentComplete {

    /**
     * 实体类--评论库
     * id           int             评论序号
     * id_index     int             评论指标
     * mark      String          评论留言内容
     * type         int             评论所属（课程0/教师1）
     * id-type      int             所属的id（课程/教师）
     * id_person    long            评论者id
     * time_content java.sql.Date   评论时间
     * score        int             评论分数
     */
    private int id;
    private String mark;
    private int type;
    private int id_type;
    private long id_person;
    private List<CommentTemp> list;
}
