package com.edu_b.edu_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EduBApplication {

    public static void main(String[] args) {
        try{
            SpringApplication.run(EduBApplication.class, args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
