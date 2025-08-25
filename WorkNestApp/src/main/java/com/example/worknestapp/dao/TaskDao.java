package com.example.worknestapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.worknestapp.model.Task;

@Repository
public class TaskDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public void saveTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.save(task);
    }
    
    public Task getTaskById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Task.class, id);
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> getAllTasks() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Task").getResultList();
    }
    
    public void updateTask(Task task) {
        Session session = sessionFactory.getCurrentSession();
        session.update(task);
    }
    
    public void deleteTask(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Task task = session.get(Task.class, id);
        session.delete(task);
    }
    
    @SuppressWarnings("unchecked")
    public List<Task> getTasksByUser(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Task t where t.assignedTo.id = :userId")
                .setParameter("userId", userId)
                .getResultList();
    }
}

