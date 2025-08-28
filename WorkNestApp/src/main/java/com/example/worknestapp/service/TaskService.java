package com.example.worknestapp.service;

import java.util.List;

import com.example.worknestapp.model.Task;

public interface TaskService {
    Integer add(Task task);
    void update(Task task);
    void delete(Integer id);
    Task get(Integer id);
    List<Task> listAll();
    List<Task> listByUser(Integer userId);
    List<Task> listByStatus(String status); // Add this method
    List<Task> listByAssignedBy(Integer adminId); // Add this method
}