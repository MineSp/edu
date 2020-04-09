package com.edu_b.edu_b.repository;

import com.edu_b.edu_b.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    /**
     * 数据访问层--系统消息
     */

    /**
     * @param idtype
     * @return
     */

    List<Comment> findAllByType(int type);

    //    List<Comment> findAllById_type(@PathVariable("id_type") Long id_type);

//    List<Comment> findAllById_indexAndTypeAndId_type(Integer id_index, Integer type, Integer id_type);
//    List<Comment> findCommentsById_indexAndTypeAndId_type(Integer id_index, Integer type, Long id_type);

//    @Override
//    List<Comment> findAllById(Iterable<Integer> integers);
}

