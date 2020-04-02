//package com.edu_b.edu_b.demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigInteger;
//
//@RestController
//public class HelloController {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @RequestMapping(value="/hello", method=RequestMethod.GET)
//    public String index() {
//
//        Long id = 201625010218L;
//        String sql = "SELECT name FROM college where id=?";
//
////         通过jdbcTemplate查询数据库
//
//        try{
//            String mobile = (String)jdbcTemplate.queryForObject(
//                sql, String.class, id);
//            return mobile;
//        }catch (Exception e){
//            e.printStackTrace();
//            String str = "无结果";
//            return str;
//        }
//    }
//}
