package com.example.worknestapp.dao;

import java.util.List;

import com.example.worknestapp.model.Comment;

public interface CommentDao {
    Integer save(Comment comment);
    void update(Comment comment);
    void delete(Integer id);
    Comment findById(Integer id);
    List<Comment> findAll();
    List<Comment> findByTask(Integer taskId);
    List<Comment> findByUser(Integer userId);
}