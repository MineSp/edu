package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * 数据访问层--用户
     */

    /**
     * 通过账号查找行数据
     * @param useraccount
     * @return
     */
    Optional<User> findByUseraccount(long useraccount);
}
