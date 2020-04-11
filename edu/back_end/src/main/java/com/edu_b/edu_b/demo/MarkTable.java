package com.edu_b.edu_b.demo;

import com.edu_b.edu_b.entity.Mark;
import lombok.Data;

@Data
public class MarkTable {
    private int id;
    private String mark;
    private String type;

    public void setData(Mark mark){
        this.id = mark.getId();
        this.mark = mark.getMark();
        if (mark.getType()==0){
            this.type="course";
        }else {
            this.type="worker";
        }
    }
}
