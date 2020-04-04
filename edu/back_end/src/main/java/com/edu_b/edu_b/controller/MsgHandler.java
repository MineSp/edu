package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.entity.Msg;
import com.edu_b.edu_b.repository.MsgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/msg")
public class MsgHandler {
    @Autowired
    private MsgRepository msgRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Msg> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return msgRepository.findAll(pageRequest);
    }

    @PostMapping("/save")
    public String Save(@RequestBody Msg msg) {
        Msg result = msgRepository.save(msg);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Msg FindById(@PathVariable("id") Integer id){
        return msgRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String Update(@RequestBody Msg msg) {
        Msg result = msgRepository.save(msg);
        if (result != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        msgRepository.deleteById(id);
    }
}
