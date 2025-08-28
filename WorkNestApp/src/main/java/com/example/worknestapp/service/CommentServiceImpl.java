package com.example.worknestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.worknestapp.dao.CommentDao;
import com.example.worknestapp.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDAO;

    @Override
    public Integer add(Comment comment) {
        return commentDAO.save(comment);
    }

    @Override
    public void update(Comment comment) {
        commentDAO.update(comment);
    }

    @Override
    public void delete(Integer id) {
        commentDAO.delete(id);
    }

    @Override
    public Comment get(Integer id) {
        return commentDAO.findById(id);
    }

    @Override
    public List<Comment> listAll() {
        return commentDAO.findAll();
    }

    @Override
    public List<Comment> listByTask(Integer taskId) {
        return commentDAO.findByTask(taskId);
    }

    @Override
    public List<Comment> listByUser(Integer userId) {
        return commentDAO.findByUser(userId);
    }
}