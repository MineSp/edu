package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.WorkerComplete;
import com.edu_b.edu_b.entity.College;
import com.edu_b.edu_b.entity.Worker;
import com.edu_b.edu_b.repository.CollegeRepository;
import com.edu_b.edu_b.repository.WorkerRepository;
//import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerHandler {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    /**
     * 按页数查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Worker> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return workerRepository.findAll(pageRequest);
    }

    @GetMapping("/findById/{id}")
    public WorkerComplete FindById(@PathVariable("id") Integer id) {
        WorkerComplete workerComplete = new WorkerComplete();
        Worker worker = workerRepository.findById(id).get();

        workerComplete.setAge(worker.getAge());
        workerComplete.setEdu(worker.getEdu());
        workerComplete.setEmail(worker.getEmail());
        workerComplete.setId_college(worker.getId_college());
        workerComplete.setSex(worker.getSex());
        workerComplete.setWorkerid(worker.getWorkerid());
        workerComplete.setId(worker.getId());
        workerComplete.setName(worker.getName());
        College college = collegeRepository.findByCollegeid(worker.getId_college()).get();
        workerComplete.setCollegename(college.getName());
        return workerComplete;
    }

//    @GetMapping("/findByName/{name}")
//    public List<Worker> findByName(@PathVariable("name") String name){
//        List<Worker> list = new
////        workerRepository.
//        return  list;
//
//    }

}
