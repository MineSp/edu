package com.edu_b.edu_b.controller;

import com.edu_b.edu_b.demo.AnylizeComment;
import com.edu_b.edu_b.demo.CommentComplete;
import com.edu_b.edu_b.entity.Comment;
import com.edu_b.edu_b.entity.Indexdb;
import com.edu_b.edu_b.repository.CommentRepository;
import com.edu_b.edu_b.repository.IndexdbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.*;


@RestController
@RequestMapping("/comment")
public class CommentHandler {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private IndexdbRepository indexdbRepository;


    @PostMapping("/save")
    public String Save(@RequestBody CommentComplete commentComplete) {
        Date date = new Date(System.currentTimeMillis());
        String result = "success";


        for (int i = 0; i < commentComplete.getList().size(); i++) {
            Comment comment = new Comment();
            comment.setId_index(commentComplete.getList().get(i).getId());
            comment.setMark(commentComplete.getMark());
            comment.setType(commentComplete.getType());
            comment.setId_type(commentComplete.getId_type());
            comment.setId_person(commentComplete.getId_person());
            comment.setScore(commentComplete.getList().get(i).getScore());
            comment.setTime_content(date);
            if (commentRepository.save(comment) == null) {
                result = "error";
            }
        }
        return result;
    }

    @GetMapping("/anylizeData/{type}/{id_type}")
    public List<AnylizeComment> anylizeData(@PathVariable("type") Integer type, @PathVariable("id_type") int id_type) {

        List<AnylizeComment> anylizeComments = new ArrayList<AnylizeComment>();

        List<Indexdb> indexdbs = indexdbRepository.findAll();
        for (int i = 0; i < indexdbs.size(); i++) {
            if (indexdbs.get(i).getOpen() == 0) {
                indexdbs.remove(i);
                i--;
            } else {
                anylizeComments.add(new AnylizeComment());
                anylizeComments.get(i).setName(indexdbs.get(i).getContent());
                float f = 0;
                float sum = 0;
                int account = 0;
                List<Comment> comment = commentRepository.findAllByType(type);
                for (int j = 0; j < comment.size(); j++) {
                    if ((indexdbs.get(i).getId() == comment.get(j).getId_index()) && (comment.get(j).getId_type() == id_type)) {
                        f += comment.get(j).getScore();
                        account++;
                    }
                }
                if (account > 0) {
                    sum = f / account;
                }
                anylizeComments.get(i).setValue(sum);
            }
        }
        return anylizeComments;
    }

}
