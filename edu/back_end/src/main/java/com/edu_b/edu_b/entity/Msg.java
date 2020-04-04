package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;


@Entity
@Data
public class Msg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id =0;
    private String title ="标题";
    private String content ="内容";
    private java.sql.Date time_publish =new Date(System.currentTimeMillis());
    private Long id_person = 1234567L;
    private String enclosure ="";

    public void setId() {
        this.id = 0;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle() {
        this.title = "通知！";
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setContent() {
        this.content = "无通知内容";
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


    public void setId_person() {
        this.id_person = 1234567L;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }

    public Long getId_person() {
        return id_person;
    }


    public void setTime_publish() {
        Date date = new Date(System.currentTimeMillis());
        this.time_publish = date;
    }

    public void setTime_publish(java.sql.Date time_publish) {

        this.time_publish = time_publish;
    }

    public java.sql.Date getTime_publish() {
        return time_publish;
    }
}
