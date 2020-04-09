package com.edu_b.edu_b.demo;

import lombok.Data;

@Data
public class UpDateUserPW {

    private long userid;
    private String oldpw;
    private String newpw;
}
