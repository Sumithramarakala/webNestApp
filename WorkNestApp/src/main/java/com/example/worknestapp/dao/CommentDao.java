package com.example.worknestapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.example.util.HibernateUtil;
import com.example.worknestapp.model.Comment;
//import com.example.worknest.util.HibernateUtil;

public class CommentDao {
    
    private SessionFactory sessionFactory;
    
    public CommentDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public void saveComment(Comment comment) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(comment);
        session.getTransaction().commit();
    }
    
    public List<Comment> getCommentsByTaskId(Long taskId) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Comment c where c.task.id = :taskId");
        query.setParameter("taskId", taskId);
        List<Comment> comments = query.getResultList();
        session.getTransaction().commit();
        return comments;
    }
    
    public Comment getCommentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        session.getTransaction().commit();
        return comment;
    }
    
    public void deleteComment(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        session.delete(comment);
        session.getTransaction().commit();
    }
}
