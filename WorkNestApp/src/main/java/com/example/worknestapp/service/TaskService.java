package com.example.worknestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.worknestapp.dao.TaskDao;
import com.example.worknestapp.model.Task;

@Service
public class TaskService {
    
    @Autowired
    private TaskDao taskDao;
    
    @Transactional
    public void saveTask(Task task) {
        taskDao.saveTask(task);
    }
    
    @Transactional(readOnly = true)
    public Task getTaskById(Long id) {
        return taskDao.getTaskById(id);
    }
    
    @Transactional(readOnly = true)
    public List<Task> getAllTasks() {
        return taskDao.getAllTasks();
    }
    
    @Transactional
    public void updateTask(Task task) {
        taskDao.updateTask(task);
    }
    
    @Transactional
    public void deleteTask(Long id) {
        taskDao.deleteTask(id);
    }
    
    @Transactional(readOnly = true)
    public List<Task> getTasksByUser(Long userId) {
        return taskDao.getTasksByUser(userId);
    }
}

