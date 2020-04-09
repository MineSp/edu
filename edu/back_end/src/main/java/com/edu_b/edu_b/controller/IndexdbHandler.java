package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.entity.Indexdb;
import com.edu_b.edu_b.repository.IndexdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indexdb")
public class IndexdbHandler {

    @Autowired
    private IndexdbRepository indexdbRepository;

    /**
     * 按页数查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Indexdb> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return indexdbRepository.findAll(pageRequest);
    }

    @GetMapping("/findAllOpen")
    public List<Indexdb> findAllOpen() {

        List<Indexdb> list = indexdbRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getOpen() == 0) {
                list.remove(i);
                i--;
            }
        }
        return list;

    }

    @PostMapping("/save")
    public String Save(@RequestBody Indexdb indexdb) {
        indexdb.setOpen(0);
        if (indexdbRepository.save(indexdb) != null) {
            return "success";
        } else {
            return "error";
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        indexdbRepository.deleteById(id);
    }

    @PutMapping("/updateOpen")
    public String UpdateOpen(@RequestBody Indexdb indexdb) {

        if (indexdbRepository.save(indexdb) != null) {
            if(indexdb.getOpen()==0){
                return "停止启用";
            }else {
                return "已启用";
            }

        } else {
            return "error";
        }
    }
}
