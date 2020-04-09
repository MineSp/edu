package com.edu_b.edu_b;


import com.edu_b.edu_b.entity.Msg;
import com.edu_b.edu_b.entity.User;
import com.edu_b.edu_b.repository.MsgRepository;
import com.edu_b.edu_b.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;


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
    void findById() {

        Optional<Msg> optional = msgRepository.findById(2);
        if (optional.isPresent()) {
            System.out.println("查到了");
            System.out.println(optional.get());
        } else {
            System.out.println("无此人");
        }

//        try {
//            msgRepository.findById(2).get();
//            System.out.println("get it");
//        } catch (Exception e) {
//            System.out.println("have no");
//        }

//        System.out.println(msgRepository.findById(2).toString());

//        if(msgRepository.findById(2).=="*/empty"){
//            System.out.println("null");
//        }

//        Msg msg = msgRepository.findById(2).get();
//        System.out.println(msg);
    }

    @Test
    void update() {
        Msg msg = msgRepository.findById(1).get();
        msg.setTitle("yiqiwangsua");
        Msg msg1 = msgRepository.save(msg);
        System.out.println(msg1);
    }

    @Test
    void delete() {
        msgRepository.deleteById(20);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    void login() {
        String result;
        try {
            User userTemp = new User();
            userTemp = userRepository.findByUseraccount(1234567L).get();
            if (userTemp.getPassword().equals("1234567")) {

                result = "登录成功！";
                userTemp.setIslogin(1);
                userRepository.save(userTemp);
            } else {
                result = "密码错误！";
            }
        } catch (Exception e) {
            result = "无此账号";
        }
        System.out.println(result);
//        return result;
//        System.out.println(userRepository.findById(1));
    }

}
