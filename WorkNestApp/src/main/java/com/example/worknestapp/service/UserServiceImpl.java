package com.example.worknestapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.worknestapp.model.User;
import com.example.worknestapp.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    @Override
    public Integer register(User user) { 
        return userDAO.save(user); 
    }

    @Override
    public void update(User user) { 
        userDAO.update(user); 
    }

    @Override
    public void delete(Integer id) { 
        userDAO.delete(id); 
    }

    @Override
    public User get(Integer id) { 
        return userDAO.findById(id); 
    }

    @Override
    public User getByEmail(String email) { 
        return userDAO.findByEmail(email); 
    }

    @Override
    public User getByName(String name) { 
        return userDAO.findByName(name); 
    }

    @Override
    public List<User> listAll() { 
        return userDAO.findAll(); 
    }
}