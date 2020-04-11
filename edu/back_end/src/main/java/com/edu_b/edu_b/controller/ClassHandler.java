package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.ClassTemp;
import com.edu_b.edu_b.entity.Class;
import com.edu_b.edu_b.repository.ClassRepository;
import com.edu_b.edu_b.repository.CollegeRepository;
import com.edu_b.edu_b.repository.SpecRepository;
import com.edu_b.edu_b.repository.WorkerRepository;
import lombok.experimental.Delegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class ClassHandler {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private SpecRepository specRepository;

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
    public Page<Class> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return classRepository.findAll(pageRequest);
    }

    @GetMapping("/findById/{id}")
    public ClassTemp findById(@PathVariable("id") Integer id) {
        Class c = classRepository.findById(id).get();
        ClassTemp classTemp = new ClassTemp();
        classTemp.setId(c.getId());
        classTemp.setName(c.getName());
        classTemp.setCollegename(collegeRepository.findByCollegeid(c.getId_college()).get().getName());
        classTemp.setSpecname(specRepository.findBySpecid(c.getId_spec()).get().getName());
        classTemp.setWorkername(workerRepository.findByWorkerid(c.getId_worker()).get().getName());
        return classTemp;
    }
}
