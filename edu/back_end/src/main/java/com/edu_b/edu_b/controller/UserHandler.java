package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.PersonalCenter;
import com.edu_b.edu_b.demo.PersonalTemp;
import com.edu_b.edu_b.demo.UpDateUserPW;
import com.edu_b.edu_b.entity.*;
import com.edu_b.edu_b.entity.Class;
import com.edu_b.edu_b.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StuRepository stuRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private SpecRepository specRepository;

    @Autowired
    private ClassRepository classRepository;
    private Worker worker;

    /**
     * 登录
     * 已测试
     *
     * @param user
     * @return
     */
    @PostMapping("/loginIn")
    public User loginIn(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByUseraccount(user.getUseraccount());
        User userTemp = new User();
        if (userOptional.isPresent()) {
            //有这个 账号 useraccount
            if (userOptional.get().getPassword().equals(user.getPassword())) {
                // 密码 password 正确
                userOptional.get().setIslogin(1);
                userRepository.save(userOptional.get());
                userTemp = userOptional.get();
            } else {
                return userTemp;
            }

        } else {
            return userTemp;
        }

        return userTemp;

    }
    @PostMapping("/loginOut")
    public String loginOut(@RequestBody User user){
        User user1 = userRepository.findByUseraccount(user.getUseraccount()).get();;
        user1.setIslogin(0);
        if (userRepository.save(user1)!=null) {

            return "退出成功";

        } else {
            return "退出失败";
        }
    }

    @GetMapping("/personalCenter/{useraccount}")
    public PersonalCenter getPersonalCenter(@PathVariable("useraccount") long useraccount) {
        PersonalCenter personalCenter = new PersonalCenter();
        User user = userRepository.findByUseraccount(useraccount).get();
        personalCenter.setUseraccount(useraccount);//账号
        personalCenter.setUsername(user.getUsername());//姓名
//        personalCenter.setImg(user.getImg());//头像
        if (user.getId_id() == 0) {
            //stu
            personalCenter.setId_idname("学生");//身份
            Stu stu = stuRepository.findByStudentid(useraccount).get();
            personalCenter.setSex(stu.getSex());//性别
            personalCenter.setAge(stu.getAge()); //年龄
            personalCenter.setEmail(stu.getEmail()); //邮箱
            Class c = classRepository.findById(stu.getId_class()).get();
            personalCenter.setClassname(c.getName());//班级
            Spec spec = specRepository.findBySpecid(stu.getId_spec()).get();
            personalCenter.setSpecname(spec.getName());//专业
            College college = collegeRepository.findByCollegeid(stu.getId_college()).get();
            personalCenter.setCollegename(college.getName());//学院

        } else if (user.getId_id() == 1) {
            //worker
            personalCenter.setId_idname("教师");//身份
            Worker worker = workerRepository.findByWorkerid(useraccount).get();
            personalCenter.setSex(worker.getSex());//性别
            personalCenter.setAge(worker.getAge()); //年龄
            personalCenter.setEmail(worker.getEmail()); //邮箱
            College college = collegeRepository.findByCollegeid(worker.getId_college()).get();
            personalCenter.setCollegename(college.getName());//学院
            personalCenter.setEdu(worker.getEdu());//学历

        } else if (user.getId_id() == 2) {
            //surpervisor
            personalCenter.setId_idname("督导员");
            Supervisor supervisor = supervisorRepository.findBySupervisorid(useraccount).get();
            personalCenter.setSex(supervisor.getSex());//sex
            personalCenter.setAge(supervisor.getAge());//age
            personalCenter.setEmail(supervisor.getEmail());//email

        } else {
            //root
            personalCenter.setId_idname("管理员");
        }
        return personalCenter;
    }

    @PutMapping("/updatePersonal")
    public String updatePersonal(@RequestBody PersonalTemp personalTemp) {
        if (personalTemp.getId_id() == 0) {
            //stu
            Stu stu = stuRepository.findByStudentid(personalTemp.getUserId()).get();
            stu.setAge(personalTemp.getAge());
            stu.setEmail(personalTemp.getEmail());
            stu.setSex(personalTemp.getSex());
            if (stuRepository.save(stu) != null) {
                return "success";
            } else {
                return "error";
            }
        } else if (personalTemp.getId_id() == 1) {
            Worker worker = workerRepository.findByWorkerid(personalTemp.getUserId()).get();
            worker.setAge(personalTemp.getAge());
            worker.setEmail(personalTemp.getEmail());
            worker.setSex(personalTemp.getSex());
            if (workerRepository.save(worker) != null) {
                return "success";
            } else {
                return "error";
            }
        } else {
            Supervisor supervisor = supervisorRepository.findBySupervisorid(personalTemp.getUserId()).get();
            supervisor.setAge(personalTemp.getAge());
            supervisor.setEmail(personalTemp.getEmail());
            supervisor.setSex(personalTemp.getSex());
            if (supervisorRepository.save(supervisor) != null) {
                return "success";
            } else {
                return "error";
            }
        }
    }

    /**
     * x修改密码
     * @param upDateUserPW
     * @return
     */
    @PutMapping("/upDatePW")
    public String update(@RequestBody UpDateUserPW upDateUserPW) {
        User user = userRepository.findByUseraccount(upDateUserPW.getUserid()).get();
        if (user.getPassword().equals(upDateUserPW.getOldpw())) {
            user.setPassword(upDateUserPW.getNewpw());
            if (userRepository.save(user) != null) {
                return "密码修改成功！";
            } else {
                return "出了点小问题，暂时无法修改";
            }
        }else {
            return "原密码错误！";
        }


    }
}
