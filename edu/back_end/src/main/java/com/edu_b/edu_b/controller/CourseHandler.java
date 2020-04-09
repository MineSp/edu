package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.CourseComplete;
import com.edu_b.edu_b.demo.WorkerComplete;
import com.edu_b.edu_b.entity.College;
import com.edu_b.edu_b.entity.Course;
import com.edu_b.edu_b.entity.Worker;
import com.edu_b.edu_b.repository.CollegeRepository;
import com.edu_b.edu_b.repository.CourseRepository;
import com.edu_b.edu_b.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseHandler {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private WorkerRepository workerRepository;

    /**
     * 按页数查询
     *
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findAll/{page}/{size}")
    public Page<Course> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return courseRepository.findAll(pageRequest);
    }

    @GetMapping("/findById/{id}")
    public CourseComplete FindById(@PathVariable("id") int id) {
        CourseComplete courseComplete = new CourseComplete();
        Course course = courseRepository.findById(id).get();

        courseComplete.setId(course.getId());
        courseComplete.setCourseid(course.getCourseid());
        courseComplete.setName(course.getName());
        courseComplete.setId_college(course.getId_college());

        College college = collegeRepository.findByCollegeid(course.getId_college()).get();
        courseComplete.setCollegename(college.getName());

        if (course.getType() == 0) {
            courseComplete.setTypename("必修");
        } else {
            courseComplete.setTypename("选修");
        }

        courseComplete.setTime_start(course.getTime_start());
        courseComplete.setId_worker(course.getId_worker());

        Worker worker = workerRepository.findByWorkerid(course.getId_worker()).get();
        courseComplete.setWorkername(worker.getName());

        courseComplete.setAddr(course.getAddr());
        courseComplete.setTime_week(course.getTime_week());
        return courseComplete;
    }
}
