package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.WorkerComplete;
import com.edu_b.edu_b.entity.*;
import com.edu_b.edu_b.repository.*;
//import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerHandler {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private StuRepository stuRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SADRepository sadRepository;

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

    @GetMapping("/findAllList/{useraccount}/{id_id}")
    public List<Worker> findAllList(@PathVariable("useraccount") long useraccount, @PathVariable("id_id") Integer id_id) {
        List<Worker> workerList = new ArrayList<>();

        if (id_id == 0) {
            //stu
            List<Stuandcourse> stuandcourseList = sadRepository.findAll();
            List<Course> courseList = courseRepository.findAll();
            for (int i = 0; i < stuandcourseList.size(); i++) {
                if (stuandcourseList.get(i).getId_stu() != useraccount) {
                    stuandcourseList.remove(i);
                    i--;
                } else {
                    for(int j = 0 ;j< courseList.size();j++){
                        if(courseList.get(j).getCourseid()==stuandcourseList.get(i).getId_course()){
                            workerList.add(workerRepository.findByWorkerid(courseList.get(j).getId_worker()).get());
                            courseList.remove(j);
                            j--;
                        }
                    }
                }
            }
            Stu stu = stuRepository.findByStudentid(useraccount).get();

        } else if (id_id == 1) {
            //worker
            List<Worker> workerList1 = workerRepository.findAll();
            Worker worker = workerRepository.findByWorkerid(useraccount).get();
            for (int i =0 ;i<workerList1.size();i++){
                if(workerList1.get(i).getId_college()== worker.getId_college()){
                    workerList.add(workerList1.get(i));
                    workerList1.remove(i);
                    i--;
                }
            }
        } else {
            workerList = workerRepository.findAll();
        }
        return workerList;
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
