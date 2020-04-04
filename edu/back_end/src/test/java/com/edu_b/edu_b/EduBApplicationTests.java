package com.edu_b.edu_b;


import com.edu_b.edu_b.entity.Msg;
import com.edu_b.edu_b.repository.MsgRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;


@SpringBootTest
class EduBApplicationTests {
    @Autowired
    private MsgRepository msgRepository;


    @Test
    void contextLoads() {
        PageRequest pageRequest = PageRequest.of(0, 3);
        Page<Msg> page = msgRepository.findAll(pageRequest);
        int i = 0;
    }

    @Test
    void save() {
        Msg msg = new Msg();
        msg.setId(1);
        msg.setTitle("泳鹅");
        msg.setContent("鹅鹅鹅，曲项向天歌。白毛浮绿水，红掌拨清波.");
        msg.setTime_publish();
        msg.setId_person(1234567L);
        System.out.println(msg);
        Msg msg1 = msgRepository.save(msg);
        System.out.println(msg1);
    }

    @Test
    void findById(){
        Msg msg = msgRepository.findById(1).get();
        System.out.println(msg);
    }

    @Test
    void update(){
        Msg msg = msgRepository.findById(1).get();
        msg.setTitle("yiqiwangsua");
        Msg msg1 = msgRepository.save(msg);
        System.out.println(msg1);
    }

    @Test
    void delete(){
        msgRepository.deleteById(20);
    }

}
