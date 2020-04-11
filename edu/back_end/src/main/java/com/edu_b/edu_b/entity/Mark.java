package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Mark {
    /**
     * private int      id;
     * private long     idperson;
     * private String   mark;
     * private int      type;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long idperson;
    private String mark;
    private int type;
}
