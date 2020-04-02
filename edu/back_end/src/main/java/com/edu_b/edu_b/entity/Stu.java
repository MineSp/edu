package com.edu_b.edu_b.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;


@Entity
@Data
public class Stu {
    @Id
    private BigInteger id;
    private String name;
    private String sex;
    private Integer age;

}
