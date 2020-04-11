package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.MarkTable;
import com.edu_b.edu_b.entity.Mark;
import com.edu_b.edu_b.entity.Stu;
import com.edu_b.edu_b.repository.MarkRepository;
import com.edu_b.edu_b.repository.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkHandler {
    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private StuRepository stuRepository;


    @GetMapping("/findAll")
    public List<MarkTable> findAll() {
        List<MarkTable> markTableList = new ArrayList<>();
        List<Mark> markList = markRepository.findAll();
        for (int i = 0; i < markList.size(); i++) {
            MarkTable markTable = new MarkTable();
            markTable.setData(markList.get(i));
            markTableList.add(markTable);
        }
        return markTableList;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        markRepository.deleteById(id);
    }


    @GetMapping("findAllByClass/{id}")
    public List<MarkTable> findAllByClass(@PathVariable("id") Integer id) {
        List<MarkTable> markTableList = new ArrayList<>();
        List<Stu> stuList = stuRepository.findAll();
        for (int i = 0; i < stuList.size(); i++) {
            if (stuList.get(i).getId_class() != id) {
                stuList.remove(i);
                i--;
            } else {
                List<Mark> markList = markRepository.findAll();
                for (int j = 1; j < markList.size(); j++) {
                    if (markList.get(j).getIdperson() == stuList.get(i).getStudentid()) {
                        MarkTable markTable = new MarkTable();
                        markTable.setData(markList.get(j));
                        markTableList.add(markTable);
                    }
                }
            }
        }
        return markTableList;
    }
}
