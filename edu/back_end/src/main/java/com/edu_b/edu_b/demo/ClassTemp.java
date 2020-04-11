package com.edu_b.edu_b.demo;

import com.edu_b.edu_b.entity.Class;
import com.edu_b.edu_b.repository.CollegeRepository;
import com.edu_b.edu_b.repository.SpecRepository;
import com.edu_b.edu_b.repository.WorkerRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class ClassTemp {
    /**
     * 伪实体类--班级
     * id           int     班级序号
     * name         String  班级名字
     * collegename  String  班级所属学院
     * workername   String  班主任
     * ispecname    String  专业
     */


    private int id;
    private String name;
    //    private long id_college;
    private String collegename;
    //    private long id_worker;
    private String workername;
    //    private long id_spec;
    private String specname;




}
