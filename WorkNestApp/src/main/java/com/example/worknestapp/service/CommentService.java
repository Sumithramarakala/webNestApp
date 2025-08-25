package com.example.worknestapp.service;

import java.util.List;

import com.example.worknestapp.dao.CommentDao;
import com.example.worknestapp.model.Comment;

public class CommentService {
    
    private CommentDao commentDao;
    
    public CommentService() {
        commentDao = new CommentDao();
    }
    
    public void saveComment(Comment comment) {
        commentDao.saveComment(comment);
    }
    
    public List<Comment> getCommentsByTaskId(Long taskId) {
        return commentDao.getCommentsByTaskId(taskId);
    }
    
    public Comment getCommentById(Long id) {
        return commentDao.getCommentById(id);
    }
    
    public void deleteComment(Long id) {
        commentDao.deleteComment(id);
    }
}

