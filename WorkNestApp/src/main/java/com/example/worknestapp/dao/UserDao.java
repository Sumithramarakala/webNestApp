package com.example.worknestapp.dao;

import java.util.List;

import com.example.worknestapp.model.User;

public interface UserDao {
    Integer save(User user);
    void update(User user);
    void delete(Integer id);
    User findById(Integer id);
    User findByEmail(String email);
    User findByName(String name); // Added for username lookup
    List<User> findAll();
}